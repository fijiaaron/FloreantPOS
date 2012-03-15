package scipio.model;

import java.math.BigDecimal;

import com.floreantpos.model.CashTransaction;
import com.floreantpos.model.CreditCardTransaction;
import com.floreantpos.model.DebitCardTransaction;
import com.floreantpos.model.PosTransaction;
import com.floreantpos.model.TicketCouponAndDiscount;
import com.floreantpos.model.TicketItem;

import scipio.model.Ticket;

public class Payment {

	PosTransaction transaction;
	int ticketId;
	double amountPaid;
	double amountDue;
	double tip;
	String method;
	CreditCard card;
	
	Ticket ticket;
	
	public Payment() {}
	
	public Payment(com.floreantpos.model.Ticket ticket) {
		setPaymentFromFloreantTicket(ticket);
	}
	
	
	///////////////////////////////////
	// Getters and Setters
	///////////////////////////////////
	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	public double getTip() {
		return tip;
	}

	public void setTip(double tip) {
		this.tip = tip;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	public void setPaymentFromFloreantTicket(com.floreantpos.model.Ticket ticket) {
		this.ticket = new Ticket(ticket);
		transaction = getTransactionFromFloreantTicket(ticket);
		
		ticketId = ticket.getId();
		amountPaid = ticket.getPaidAmount();
		amountDue = ticket.getDueAmount();
		tip = ticket.getGratuity().getAmount();
		method = ticket.getTransactionType();
		
		if (method.equals(PosTransaction.TYPE_CREDIT_CARD) || method.equals(PosTransaction.TYPE_DEBIT_CARD)) {
			card = new CreditCard();
			card.setCardHolder("Not Available");
			card.setExp("N/A");
			card.setType(ticket.getCardType());
			card.setNumber(getLast(4, ticket.getCardNumber()));
		}
		
	}
	
	public String getLast(int digits, String s) {
		int length = s.length();
		
		if (digits <= length) {
			return s;
		}
		
		return s.substring(length - digits);
	}
	
	public PosTransaction getTransactionFromFloreantTicket(com.floreantpos.model.Ticket ticket) {
		PosTransaction transaction = null;
		//TODO: get from DB
		
		if (ticket.getTransactionType().equals(PosTransaction.TYPE_CASH)) {
			transaction = new CashTransaction();
		} 
		else if (ticket.getTransactionType().equals(PosTransaction.TYPE_CREDIT_CARD)) {
			transaction = new CreditCardTransaction();
		}
		else if (ticket.getTransactionType().equals(PosTransaction.TYPE_DEBIT_CARD)) {
			transaction = new DebitCardTransaction();
		}
		else {
			// transaction type not supported
		}

		double subtotal = 0.0;
		for (TicketItem item : ticket.getTicketItems()) {
			subtotal += item.getTotalAmount();
		}
	
		double discount = 0.0;
		for(TicketCouponAndDiscount coupon : ticket.getCouponAndDiscounts()) {
			discount += coupon.getValue();
		}
		
		double taxRate = 0.06;
		double tax = (subtotal - discount) * taxRate;

		double gratuity = ticket.getGratuity().getAmount();
		double total = subtotal - discount + tax + gratuity;
		
		transaction.setId(1);
		transaction.setSubtotalAmount(subtotal);
		transaction.setDiscountAmount(discount);
		transaction.setTaxAmount(tax);
		transaction.setGratuityAmount(gratuity);
		transaction.setTotalAmount(total);
		transaction.setTransactionTime(ticket.getClosingDate());
		transaction.setModifiedTime(ticket.getModifiedTime());
		transaction.setTerminal(ticket.getTerminal());
		
		return transaction;
	}

}
