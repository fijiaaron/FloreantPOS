package scipio.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"application", "pos", "merchant", "consumer", "ticket", "payment", "coupons"})
public class Receipt {
	
	Application application;
	Pos pos;
	Merchant merchant;
	Consumer consumer;
	Ticket ticket;
	//com.floreantpos.model.Ticket ticket;
	Payment payment;
	List<Coupon> coupons;
	
	///////////////////////////////////
	// Getters and Setters
	///////////////////////////////////

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	
	public Pos getPos() {
		return pos;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	

	public void setTicket(com.floreantpos.model.Ticket ticket) {
		this.ticket = new Ticket(ticket);
	}


//	public com.floreantpos.model.Ticket getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(com.floreantpos.model.Ticket ticket) {
//		this.ticket = ticket;
//	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}
	
	public void addCoupon(Coupon coupon) {
		if (coupons == null) {
			coupons = new ArrayList<Coupon>();
		}
		coupons.add(coupon);
	}

	public int getTotalLineItems() {
		int totalLineItems = 0;
		return totalLineItems;
	}
	
	public BigDecimal getTransactionTotal() {
		BigDecimal transactionTotal = null;
		return transactionTotal;
	}
	
}
