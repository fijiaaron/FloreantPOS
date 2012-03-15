package scipio.model;

import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Hibernate;

import com.floreantpos.model.CashTransaction;
import com.floreantpos.model.PosTransaction;
import com.floreantpos.model.TicketItem;
import com.floreantpos.model.dao.CashTransactionDAO;
import com.floreantpos.model.dao._RootDAO;

import scipio.LineItem;

public class Ticket {
	private int ticketId;
	
	private Date created;
	private Date activated;
	private Date modified;
	private Date closed;
	
	private String status;
	private double amountPaid;
	private double amountDue;
	
	private List<LineItem> items;
	

	///////////////////////////////////
	// Constructors
	///////////////////////////////////

	public Ticket() {}
	
	public Ticket(com.floreantpos.model.Ticket ticket) {
		setTicketFromFloreantPOS(ticket);
	}

	
	///////////////////////////////////
	// Getters and Setters
	///////////////////////////////////
	
	public List<LineItem> getItems() {
		return items;
	}
	
	public void setItems(List<LineItem> items) {
		this.items = items;
	}
	
	public void addItem(LineItem item) {
		items.add(item);
	}
	
	public int getTotalItems() {
		int totalItems = 0;
		
		for (LineItem item : items) {
			totalItems += item.getQty();
		}
		
		return totalItems;
	}
	
	
	

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getActivated() {
		return activated;
	}

	public void setActivated(Date activated) {
		this.activated = activated;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getClosed() {
		return closed;
	}

	public void setClosed(Timestamp closed) {
		this.closed = closed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
	

	///////////////////////////////////
	// Helpers
	///////////////////////////////////

	private void setTicketFromFloreantPOS(com.floreantpos.model.Ticket ticket) {
		
		ticketId = ticket.getId();
		created = ticket.getCreateDate();
		activated = ticket.getActiveDate();
		modified = ticket.getModifiedTime();
		closed = ticket.getClosingDate();
				
		amountDue = ticket.getDueAmount();
		amountPaid = ticket.getPaidAmount();
		
		if (amountPaid >= amountDue) {
			status = "PAID";
		} else if (amountPaid <= 0) {
			status = "NOT PAID";
		} else {
			status = "PARTIALLLY PAID";
		}
		
		for(TicketItem ticketItem : ticket.getTicketItems()) {
			LineItem item = new LineItem();
			
			item.setDescription(ticketItem.getName());
			item.setInventoryId(String.valueOf(ticketItem.getItemId()));
			item.setQty(ticketItem.getItemCount());
			item.setUnitPrice(ticketItem.getUnitPrice());
			
			if (items == null) {
				items = new ArrayList<LineItem>();
			}
			items.add(item);
		}
	}
}
