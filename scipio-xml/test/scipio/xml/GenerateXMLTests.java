package scipio.xml;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import scipio.xml.model.ObjectFactory;
import scipio.xml.model.Receipt;
import scipio.xml.model.Util;

public class GenerateXMLTests {

	public static final String UTF_8 = "UTF-8";
	public ObjectFactory builder = new ObjectFactory();
	
	@Test
	public void testSanity() {
		assertTrue(true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFromNullReceipt() throws Exception {
		Receipt receipt = null;
		generateReceiptXML(receipt);
	}
	
	@Test
	public void testFromEmptyReceipt() throws Exception {
		Receipt receipt = new Receipt();
		String xml = generateReceiptXML(receipt);
		assertNotNull(xml);
		assertTrue(xml.startsWith("<?xml"));
		assertTrue(xml.contains("receipt"));
	}
	
	@Test
	public void testFromReceipt1() throws Exception {
		Receipt receipt = new Receipt();
		receipt.setApplication(getApplication());
		receipt.setPos(getPos());
		receipt.setMerchant(getMerchant());
		receipt.setTerminal(getTerminal());
		receipt.setConsumer(getConsumer());
		receipt.setTransaction(getTransaction());
		receipt.setPayment(getPayment(getTransaction()));
		String xml = generateReceiptXML(receipt);

		System.out.println(xml);
		
		assertNotNull(xml);
		assertTrue(xml.startsWith("<?xml"));
		assertTrue(xml.contains("receipt"));
		assertTrue(xml.contains("<status>PAID</status>"));
	}

	// create test data
	
	public Receipt.Application getApplication() {
		Receipt.Application application = new Receipt.Application();
		application.setAppId(123456);
		return application;				
	}

	public Receipt.Pos getPos() {
		String posName="FloreantPOS";
		String posVersion="1.0.2b";
		Receipt.Pos pos = new Receipt.Pos(posName, posVersion);
		return pos;
	}

	public Receipt.Merchant getMerchant() {
		Receipt.Merchant merchant = builder.createReceiptMerchant();
		merchant.setSmi("A1234F");
		merchant.setUsername("username");
		merchant.setAddress(getAddress());
		merchant.setId(0);
		merchant.setStoreNumber(1);
		merchant.setTelephone("425-242-4304");
		merchant.setType("restaurant");
		return merchant;
	}
	
	public Receipt.Merchant.Address getAddress() {
		Receipt.Merchant.Address address = builder.createReceiptMerchantAddress();
		address.setAddress1("123 Main St.");
		address.setAddress2("Seattle, WA");
		address.setAddress3("98104");
		return address;
	}
	
	public Receipt.Consumer getConsumer() {
		Receipt.Consumer consumer = builder.createReceiptConsumer();
		consumer.setPei(12345);
		consumer.setPin(1234);
		consumer.setTei(123456);
		return consumer;
	}
	
	public Receipt.Terminal getTerminal() {
		Receipt.Terminal terminal = builder.createReceiptTerminal();
		terminal.setId(1);
		terminal.setName("terminal");
		return terminal;
	}
	
	public Receipt.Transaction getTransaction() throws Exception {
		Receipt.Transaction transaction = builder.createReceiptTransaction();
		
		Receipt.Transaction.Closed closed = new Receipt.Transaction.Closed();
		closed.setDateAndTime(new Date());
		
		transaction.setCreated(Util.getCalendar(new Date()));
		transaction.setActivated(Util.getCalendar(new Date()));
		transaction.setClosed(closed);
		transaction.setTransactionId(5);
		transaction.setTableNumber((short)1);
		transaction.setNumberofGuests((short)2);
		transaction.setServerName("Lucy");
		transaction.setItems(getItems());
		transaction.setDiscounts(getDiscounts());
		transaction.setSalestax(getSalesTax(transaction));

		double tip = 0.50;
		transaction.setTip(tip);
		
		BigDecimal amountPaid = transaction.getGrandTotal();
		transaction.setAmountPaid(amountPaid);
		transaction.setStatus(transaction.getStatus());
		
		return transaction;
	}
	
	public Receipt.Transaction.Items getItems() {
		Receipt.Transaction.Items items = new Receipt.Transaction.Items();
		
		Receipt.Transaction.Items.Item item1 = builder.createReceiptTransactionItemsItem();
		item1.setDescription("Coke");
		item1.setInventoryId(154);
		item1.setQty(2);
		item1.setUnitPrice(2.00);
		item1.getTotal();
		item1.setTotal(Util.multiply(item1.getQty(), item1.getUnitPrice()));
		Receipt.Transaction.Items.Item.Coupon coupon1 = builder.createReceiptTransactionItemsItemCoupon();
		coupon1.setId(1);
		item1.setCoupon(coupon1);
		items.getItem().add(item1);
		
		Receipt.Transaction.Items.Item item2 = builder.createReceiptTransactionItemsItem();
		item2.setDescription("Coke");
		item2.setInventoryId(154);
		item2.setQty(4);
		item2.setUnitPrice(1.00);
		
		item2.setTotal(Util.multiply(item2.getQty(), item2.getUnitPrice()));
		Receipt.Transaction.Items.Item.Coupon coupon2 = builder.createReceiptTransactionItemsItemCoupon();
		coupon2.setId(10);
		item2.setCoupon(coupon2);
		items.getItem().add(item2);
		
		BigDecimal subtotal = Util.double2decimal(0.00);
		int quantity = 0;
		for (Receipt.Transaction.Items.Item item : items.getItem()) {
			quantity += item.getQty();
			subtotal = subtotal.add(item.getTotal());
		}
		
		items.setSubtotal(subtotal);
		items.setQuantity(quantity);
		return items;
	}
	
	public Receipt.Transaction.Discounts getDiscounts() {
		Receipt.Transaction.Discounts discounts = builder.createReceiptTransactionDiscounts();
		discounts.setRewards("");
		Receipt.Transaction.Discounts.Coupons coupons = new Receipt.Transaction.Discounts.Coupons();
		coupons.getCoupon().add(new Receipt.Transaction.Discounts.Coupons.Coupon(1, "Coupon 1", 1.00));
		coupons.getCoupon().add(new Receipt.Transaction.Discounts.Coupons.Coupon(2, "Coupon 2", 1.00));
		discounts.setCoupons(coupons);
		
		BigDecimal value = Util.double2decimal(0.00);
		int quantity = 0;
		for (Receipt.Transaction.Discounts.Coupons.Coupon coupon : coupons.getCoupon()) {
			value = value.add(coupon.getValue());
			quantity += coupon.getQuantity();
		}
		
		discounts.setQuantity(quantity);
		discounts.setValue(value);
		
		return discounts;
	}
	
	public Receipt.Transaction.Salestax getSalesTax(Receipt.Transaction transaction) {
		Receipt.Transaction.Salestax salestax = builder.createReceiptTransactionSalestax();
		salestax.setRate(0.06);
		salestax.setTaxableAmount(transaction.getSubtotal().subtract(transaction.getDiscount()));
		return salestax;
	}
	

	public Receipt.Payment getPayment(Receipt.Transaction transaction) {
		Receipt.Payment payment = builder.createReceiptPayment();
		payment.setAmountCharged(transaction.getAmountPaid());
		payment.setAuthorizationCode(1234);
		payment.setCard(getCreditCard());
		payment.setGrandTotal(payment.getAmountCharged());
		payment.setMethod("CREDIT_CARD");
		return payment;
	}
	
	public Receipt.Payment.Card getCreditCard() {
		Receipt.Payment.Card creditcard = builder.createReceiptPaymentCard();
		creditcard.setCardHolder(new Receipt.Payment.Card.CardHolder("Joe", "Smith"));
		creditcard.setNumber(1234);
		creditcard.setExpiration("12/2012");
		creditcard.setType("VISA");
		
		return creditcard;
	}
	
	// generate xml
	
	public String generateReceiptXML(Receipt receipt) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(Receipt.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//marshaller.marshal(receipt, System.out);

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		marshaller.marshal(receipt, stream);
		
		String xmlString = null;
		try {
			xmlString = stream.toString(UTF_8);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return xmlString;
	}
	
	
	
}
