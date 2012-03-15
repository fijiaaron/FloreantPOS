package scipio.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StatelessSession;

import com.floreantpos.model.dao._RootDAO;

public class ScipioDAO extends _RootDAO {

	@Override
	protected Class getReferenceClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List getTicketInfo(com.floreantpos.model.Ticket ticket) {
		int ticket_id = ticket.getId();
		
		
		Session session = sessionFactory.openSession();
		//Session session = createNewSession();
		//StatelessSession session = sessionFactory.openStatelessSession();
		String sql = "select " +
				"t.id as ticket_id, " +
				"t.paid, " +
				"t.sub_total, as subtotal" +
				"t.total_discount, " +
				"t.total_tax, " +
				"t.total_price, " +
				"t.paid_amount, " +
				"t.due_amount, " +
				"t.card_number, " +
				"t.card_type, " +
				"tx.payment_type, " +
				"c.name as coupon_name, " +
				"c.value as coupon_amount, " +
				"g.amount as gratuity_amount " +
				"from ticket t, transactions tx, ticket_coupon_discount c, gratuity g " +
				"where t.id = tx.ticket_id and t.id = c.ticket_id and t.id = g.ticket_id " +
				"and t.id = :ticket_id";
		
		Query query = session.createSQLQuery(sql).setParameter("ticket_id", ticket_id);
//			.addScalar("ticket_id", Hibernate.LONG)
//			.addScalar("paid", Hibernate.BOOLEAN)
//			.addScalar("subtotal", Hibernate.BIG_DECIMAL)
//			.addScalar("discount"")
		
		List results = query.list();
		System.out.println(results);
		return results;
	}
}