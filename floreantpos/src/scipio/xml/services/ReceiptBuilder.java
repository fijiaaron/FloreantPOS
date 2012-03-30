//-AE-
package scipio.xml.services;

import com.floreantpos.model.Restaurant;
import com.floreantpos.model.ScipioInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Properties;
import java.util.HashMap;

import com.floreantpos.model.Ticket;
import com.floreantpos.model.dao.RestaurantDAO;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import scipio.xml.model.Receipt;
import scipio.xml.model.Receipt.Application;
import scipio.xml.model.Receipt.Consumer;
import scipio.xml.model.Receipt.Merchant;
import scipio.xml.model.Receipt.Merchant.Address;
import scipio.xml.model.Receipt.Payment;
import scipio.xml.model.Receipt.Payment.Card;
import scipio.xml.model.Receipt.Pos;
import scipio.xml.model.Receipt.Terminal;
import scipio.xml.model.Receipt.Transaction;
import scipio.xml.model.Receipt.Transaction.Discounts.Coupons.Coupon;
import scipio.xml.model.Receipt.Transaction.Items.Item;
import scipio.xml.model.Receipt.Transaction.Salestax;
import scipio.xml.model.Util;

public class ReceiptBuilder {

	Properties scipio;
	private static final Logger log = Logger.getLogger(ReceiptBuilder.class.getName());
	
	public ReceiptBuilder() {
		scipio = getScipioProperties();
	}
	
	public File getApplicationDir() {
		File applicationDir = null;
				
		try {
			applicationDir = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
			System.out.println(applicationDir.getCanonicalPath());
		} catch (URISyntaxException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return applicationDir;
	}
		
	public File getScipioPropertiesFile() throws IOException {
		String path = getApplicationDir().getCanonicalPath() + "/" + "scipio.properties";
		return new File(path);
	}
	
	public Properties getScipioProperties() {
		Properties properties = null;
		
		try {
			properties = new Properties();
			InputStream in = new FileInputStream(getScipioPropertiesFile());
			properties.load(in);
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
			//Logger.getLogger(ReceiptBuilder.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			//Logger.getLogger(ReceiptBuilder.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return properties;
	}
	
	
	public Receipt createReceipt(Ticket ticket) throws ScipioException, Exception {

		Receipt r = new Receipt();

		String appId = scipio.getProperty("application.id");
		Application application = new Application(appId);

		String posName = scipio.getProperty("pos.name");
		String posVersion = scipio.getProperty("pos.version");
		Pos pos = new Pos(posName, posVersion);

		r.setApplication(application);
		r.setPos(pos);
		
		Restaurant restaurant = RestaurantDAO.getInstance().get(Integer.valueOf(1));
		Merchant merchant = new Merchant();
		merchant.setType("restaurant");
		merchant.setId(restaurant.getId());
		merchant.setAddress(new Address(restaurant.getAddressLine1(), restaurant.getAddressLine2(), restaurant.getAddressLine3()));
		merchant.setTelephone(restaurant.getTelephone());
		merchant.setSmi(scipio.getProperty("merchant.smi"));
		merchant.setStoreNumber(scipio.getProperty("merchant.store.number"));
		merchant.setUsername(scipio.getProperty("merchant.username"));
		r.setMerchant(merchant);
		
		ScipioInfo scipioInfo = new ScipioInfo();
		
		//TODO: get ScipioInfo from database
		int pei = Integer.valueOf(scipio.getProperty("consumer.pei"));
		int pin = 1234;
		int tei = 12345;
		scipioInfo.setPEI(pei);
		scipioInfo.setPIN(tei);
		scipioInfo.setTEI(pin);
		
		Consumer consumer = new Consumer(scipioInfo.getPEI(), scipioInfo.getPIN(), scipioInfo.getTEI());
		
		r.setConsumer(consumer);
		return r;
	}
	
	
	
	public static Receipt createReceipt(Properties p) {
		Receipt receipt = new Receipt();
		
		String appId = p.getProperty("application.id");
		Application application = new Application(appId);
		
		String posName = p.getProperty("pos.name");
		String posVersion = p.getProperty("pos.version");
		Pos pos = new Pos(posName, posVersion);
		
		String merchantSMI = p.getProperty("merchant.smi");
		String merchantUsername = p.getProperty("merchant.username");
		String merchantAddress1 = p.getProperty("merchant.address.address1");
		String merchantAddress2 = p.getProperty("merchant.address.address2");
		String merchantAddress3 = p.getProperty("merchant.address.address3");
		String merchantId = p.getProperty("merchant.id");
		String merchantStoreNumber = p.getProperty("merchant.store.number");
		String merchantTelephone = p.getProperty("merchant.telephone");
		String merchantType = p.getProperty("merchant.type");
		
		Merchant merchant = new Merchant(merchantId);
		merchant.setSmi(merchantSMI);
		merchant.setUsername(merchantUsername);
		merchant.setAddress(new Address(merchantAddress1, merchantAddress2, merchantAddress3));
		merchant.setTelephone(merchantTelephone);
		merchant.setStoreNumber(merchantStoreNumber);
		merchant.setType(merchantType);
		
		
		String consumerPEI = p.getProperty("consumer.pei");
		String consumerPIN = p.getProperty("consumer.pin");
		String consumerTEI = p.getProperty("consumer.tei");
		Consumer consumer = new Consumer(consumerPEI, consumerPIN, consumerTEI);
		
		String terminalId = p.getProperty("terminal.id");
		String terminalName = p.getProperty("terminal.name");
		Terminal terminal = new Terminal(terminalId, terminalName);

		String transactionId = p.getProperty("transaction.id");
		Transaction transaction = new Transaction(transactionId);
		transaction.setClosed(new Date() {});
		
		for (int i=0; i<10; i++) {
			String pDescription = "transaction.items." + i + ".description";
			String pInventoryId = "transaction.items." + i + ".inventoryId";
			String pPrice = "transaction.items." + i + ".unitprice";
			String pQuantity = "transaction.items." + i + ".quantity";
			String pCouponId = "transaction.items." + i + ".coupon.id";
			
			String description = p.getProperty(pDescription);
			String inventoryId = p.getProperty(pInventoryId);
			String price = p.getProperty(pPrice);
			String quantity = p.getProperty(pQuantity);
			String couponId = p.getProperty(pCouponId);
			
			if (description != null || inventoryId != null || price != null || quantity != null) {
				Item item = new Item();
				
				item.setDescription(description);
				item.setItemId(inventoryId);
				item.setUnitPrice(Double.valueOf(price));
				item.setQty(Integer.valueOf(quantity));
				
				if (couponId != null) {
					item.setCoupon(new scipio.xml.model.Receipt.Transaction.Items.Item.Coupon(couponId));
				}
				
				//System.out.println("adding item #" + item.getInventoryId() + ": " + item.getQty() + "x " + item.getDescription() + " @ " + item.getUnitPrice() + " each");
				
				transaction.getItems().getItem().add(item);
			}
		}

		int itemsQty = 0;
		BigDecimal itemsSubtotal = new BigDecimal(0.00);
		for (Item item : transaction.getItems().getItem()) {
			itemsQty += item.getQty();
			itemsSubtotal = itemsSubtotal.add(item.getTotal());
		}
		transaction.getItems().setQuantity(itemsQty);
		transaction.getItems().setSubtotal(itemsSubtotal);
		
		for (int i=0; i<10; i++) {
			String pId = "transaction.discounts." + i + ".coupon.id";
			String pName = "transaction.discounts." + i + ".coupon.name";
			String pValue = "transaction.discounts." + i + ".coupon.value";
			String pQuantity = "transaction.discounts." + i + ".coupon.quantity";
					
			String id = p.getProperty(pId);
			String name = p.getProperty(pName);
			String value = p.getProperty(pValue);
			String quantity = p.getProperty(pQuantity);
			
			if (id != null || name != null || value != null) {
				if (quantity == null) {
					quantity = "1";
				}
				
				Coupon coupon = new Coupon(id, name, Double.valueOf(value), Integer.valueOf(quantity));
				coupon.setQuantity(Integer.valueOf(quantity));
				
				transaction.getDiscounts().getCoupons().getCoupon().add(coupon);
			}
		}
		
		int discountsQty = 0;
		BigDecimal discountsSubtotal = new BigDecimal(0.00);
		for (Coupon coupon : transaction.getDiscounts().getCoupons().getCoupon()) {
			discountsQty += coupon.getQuantity();
			discountsSubtotal = discountsSubtotal.add(Util.multiply(coupon.getValue(), coupon.getQuantity()));
		}
		transaction.getDiscounts().setQuantity(discountsQty);
		transaction.getDiscounts().setValue(discountsSubtotal);
		
		//transaction.setSubtotal(transaction.getSubtotal());
		
		String salesTaxRate = p.getProperty("salestax.rate");
		Salestax salestax = new Salestax(Double.valueOf(salesTaxRate));
		salestax.setTaxableAmount(transaction.getSubtotal().subtract(transaction.getDiscount()));
		transaction.setSalestax(salestax);
		
		String tip = p.getProperty("payment.tip");
		transaction.setTip(Double.valueOf(tip));
		
		transaction.setAmountPaid(transaction.getGrandTotal());
		
		String paymentMethod = p.getProperty("payment.method");
		String paymentAmountCharged = p.getProperty("payment.amount");
		String paymentTotal = p.getProperty("payment.total");
		
		String cardType = p.getProperty("payment.card.type");
		String cardNumber = p.getProperty("payment.card.number");
		String cardExp = p.getProperty("payment.card.exp");
		String cardHolder = p.getProperty("payment.card.holder");
		
		Payment payment = new Payment(paymentMethod);
		payment.setCard(new Card(cardType, cardNumber, cardExp, cardHolder));
		payment.setAmountCharged(Double.valueOf(paymentAmountCharged));
		payment.setGrandTotal(Double.valueOf(paymentTotal));
		
		receipt.setApplication(application);
		receipt.setPos(pos);
		receipt.setMerchant(merchant);
		receipt.setTerminal(terminal);
		receipt.setConsumer(consumer);
		receipt.setTransaction(transaction);
		receipt.setPayment(payment);
		
		transaction.setStatus(transaction.getStatus());
		return receipt;
	}
	
}
