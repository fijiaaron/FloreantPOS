import static org.junit.Assert.*;
import org.junit.Test;

import scipio.model.dao.ScipioDAO;

import com.floreantpos.model.Ticket;



public class TestSanity {
	@Test
	public void isSane() {
		assertEquals(true, true);
	}
	
	@Test
	public void canGetTicket() {
		int ticket_id = 5;
		Ticket ticket = new Ticket(ticket_id);
		
		System.out.println(ticket);
	}
	
	@Test
	public void canUseScipioDAO() {
		ScipioDAO scipio = new ScipioDAO();
		Ticket ticket = new Ticket(5);
		scipio.getTicketInfo(ticket);
	}
}
