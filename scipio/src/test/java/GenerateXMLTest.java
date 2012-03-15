import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import scipio.model.Address;
import scipio.model.Application;
import scipio.model.Consumer;
import scipio.model.Coupon;
import scipio.model.Merchant;
import scipio.model.Payment;
import scipio.model.PhoneNumber;
import scipio.model.Pos;
import scipio.model.Receipt;


import com.floreantpos.model.CouponAndDiscount;
import com.floreantpos.model.Gratuity;
import com.floreantpos.model.PosTransaction;
import com.floreantpos.model.Restaurant;
import com.floreantpos.model.Terminal;
import com.floreantpos.model.Ticket;
import com.floreantpos.model.TicketCouponAndDiscount;
import com.floreantpos.model.TicketItem;


public class GenerateXMLTest {

	static Logger log = Logger.getLogger("GenerateXML");	
	
	@Test
	public void generateXML() throws JAXBException {
		
		Receipt receipt = new Receipt();

		// application info
		Application application = new Application();
		application.setAppId("123456");
		application.setUsername("username");
		application.setSmi("A1234F");
		
		receipt.setApplication(application);
		
		// pos info
		Pos pos = new Pos();
		pos.setName("FloreantPOS");
		pos.setVersion("1.0.2b");
		
		receipt.setPos(pos);
		
		// merchant info
		Restaurant restaurant = getRestaurant();
		
		Merchant merchant = new Merchant(12345);
		merchant.setType("restaurant");
		merchant.setName(restaurant.getName());
		merchant.setTelephone(new PhoneNumber(restaurant.getTelephone()));
		merchant.setRegisterNumber(1);
		merchant.setStoreNumber(1);

		Address address = new Address();
		address.setAddress1(restaurant.getAddressLine1());
		address.setAddress2(restaurant.getAddressLine2());
		address.setAddress3(restaurant.getAddressLine3());
		
		merchant.setAddress(address);
		
		receipt.setMerchant(merchant);
		
		// consumer info
		Consumer consumer = new Consumer();
		consumer.setName("John Smith");
		consumer.setPei(12345);
		consumer.setTei(123456);
		consumer.setPin(1234);
		
		receipt.setConsumer(consumer);
		
		
		// ticket info
		Ticket ticket = getTicket();
		receipt.setTicket(ticket);
		
		// payment info 
		Payment payment = new Payment(ticket);
		receipt.setPayment(payment);
	
		
		// coupon info
		for(TicketCouponAndDiscount couponAndDiscout : ticket.getCouponAndDiscounts()) {
			Coupon coupon = new Coupon();
			coupon.setName(couponAndDiscout.getName());
			coupon.setNumber(String.valueOf(couponAndDiscout.getCouponAndDiscountId()));
			receipt.addCoupon(coupon);
		}
		
		JAXBContext context;

		context = JAXBContext.newInstance(Receipt.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(receipt, System.out);
		
	}
	
	public Ticket getTicket() {
		
		Date createDate = Calendar.getInstance().getTime();
		Date activeDate = Calendar.getInstance().getTime();
		Date closingDate = Calendar.getInstance().getTime();
		
		String cardType = "VISA";
		String cardNumber = "9876";
		String cardExp = "12/2012";
		String cardHolder = "Joe Smith";
		
		List<TicketCouponAndDiscount> couponAndDiscounts = new ArrayList<TicketCouponAndDiscount>();
		TicketCouponAndDiscount coupon1 = new TicketCouponAndDiscount();
		coupon1.setId(1);
		coupon1.setName("Coupon 1");
		coupon1.setValue(1.0);
		couponAndDiscounts.add(coupon1);
		
		TicketCouponAndDiscount coupon2 = new TicketCouponAndDiscount();
		coupon2.setId(2);
		coupon2.setName("Coupon 2");
		coupon2.setValue(2.0);
		couponAndDiscounts.add(coupon2);
		
		Gratuity gratuity = new Gratuity();
		gratuity.setId(1);
		gratuity.setAmount(2.50);
		
		List<TicketItem> items = new ArrayList<TicketItem>();
		TicketItem item1 = new TicketItem();
		item1.setId(1);
		item1.setItemId(1);
		item1.setBeverage(true);
		item1.setGroupName("Beverages");
		item1.setCategoryName("Cold Drinks");
		item1.setItemCount(2);
		item1.setName("Coke");
		item1.setUnitPrice(decimal(2.0));
		item1.setSubtotalAmount(item1.getUnitPrice() * item1.getItemCount());
		item1.setDiscountAmount(0.0);
		item1.setDiscountRate(0.10);
		double item1_discountedSubtotal = (item1.getSubtotalAmount() - item1.getDiscountAmount()) * (1.0 - item1.getDiscountRate()) ; 
		item1.setTaxRate(0.06);
		item1.setTaxAmount(item1.getTaxRate() * item1_discountedSubtotal);
		double item1_totalAmount = decimal(item1_discountedSubtotal - item1.getTaxAmount());
		item1.setTotalAmount(item1_totalAmount);
		
		
		TicketItem item2 = new TicketItem();
		item2.setId(2);
		item2.setItemId(2);
		item2.setBeverage(false);
		item2.setGroupName("Favorites");
		item2.setCategoryName("Breakfast");
		item2.setItemCount(4);
		item2.setName("Egg");
		item2.setUnitPrice(decimal(1.0));
		item2.setSubtotalAmount(item2.getUnitPrice() * item2.getItemCount());
		item2.setDiscountAmount(1.0);
		item2.setDiscountRate(0.0);
		double item2_discountedSubtotal = (item2.getSubtotalAmount() - item2.getDiscountAmount()) * (1.0 - item2.getDiscountRate()) ; 
		item2.setTaxRate(0.06);
		item2.setTaxAmount(item2.getTaxRate() * item2_discountedSubtotal);
		double item2_totalAmount = decimal(item2_discountedSubtotal - item2.getTaxAmount());
		item2.setTotalAmount(item2_totalAmount);
						
		TicketItem item3 = new TicketItem();
		item3.setId(3);
		item3.setItemId(3);
		item3.setBeverage(false);
		item3.setGroupName("Favorites");
		item3.setCategoryName("Breakfast");
		item3.setItemCount(1);
		item3.setName("Bacon");
		item3.setUnitPrice(decimal(1.5));
		item3.setSubtotalAmount(item3.getUnitPrice() * item3.getItemCount());
		item3.setDiscountAmount(0.0);
		item3.setDiscountRate(0.0);
		double item3_discountedSubtotal = (item3.getSubtotalAmount() - item3.getDiscountAmount()) * (1.0 - item3.getDiscountRate()) ; 
		item3.setTaxRate(0.06);
		item3.setTaxAmount(item3.getTaxRate() * item3_discountedSubtotal);
		double item3_totalAmount = decimal(item3_discountedSubtotal - item3.getTaxAmount());
		item3.setTotalAmount(item3_totalAmount);
		
		items.add(item1);
		items.add(item2);
		items.add(item3);
		
		
		BigDecimal x = new BigDecimal(0.00);
		x.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		double subtotal = 0.0;
		for (TicketItem item : items) {
			subtotal += item.getTotalAmount();
		}
		
		subtotal = x.add(new BigDecimal(subtotal)).doubleValue();
		subtotal = decimal(subtotal);
		
		double discounts = 0.0;
		for(TicketCouponAndDiscount discount : couponAndDiscounts) {
			discounts += discount.getValue();
		}
		
		discounts = decimal(discounts);
		
		double taxRate = 0.06;
		double tax = (subtotal - discounts) * taxRate;
		
		double total = subtotal - discounts + tax + gratuity.getAmount();
		total = decimal(total);
		
	
		
		double amountPaid = total;
		double amountDue = 0.00;
		boolean isPaid = amountPaid >= total ? true : false;
		
		Terminal terminal = new Terminal();
		terminal.setId(1);
		terminal.setName("1234");
		
		Ticket ticket = new Ticket();
		ticket.setId(5);
		ticket.setTerminal(terminal);
		
		ticket.setCreateDate(createDate);
		ticket.setActiveDate(activeDate);
		ticket.setClosingDate(closingDate);
		ticket.setClosed(true);
		ticket.setCardNumber(cardNumber);
		ticket.setCardType(cardType);
		ticket.setCouponAndDiscounts(couponAndDiscounts);
		
		ticket.setSubtotalAmount(subtotal);
		ticket.setDiscountAmount(discounts);
		ticket.setTaxAmount(tax);
		ticket.setGratuity(gratuity);
		ticket.setTotalAmount(total);
		
		ticket.setDueAmount(decimal(amountDue));
		ticket.setPaidAmount(decimal(amountPaid));
		ticket.setPaid(isPaid);
		
		ticket.setTransactionType(PosTransaction.TYPE_CREDIT_CARD);
		
		ticket.setTicketItems(items);
		return ticket;
	}
	
	public Restaurant getRestaurant() {
		Restaurant restaurant = new Restaurant();
		restaurant.setAddressLine1("123 Main St.");
		restaurant.setAddressLine2("Seattle, WA");
		restaurant.setAddressLine3("98104");
		restaurant.setTelephone("425-242-4304");
		restaurant.setId(12345);
		
		return restaurant;
	}

	public double decimal(double value) {
		return new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
