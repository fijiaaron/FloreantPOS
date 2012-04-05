//-AE-

package com.floreantpos.model.dao;

import com.floreantpos.model.CouponAndDiscount;
import com.floreantpos.model.ScipioInfo;
import com.floreantpos.model.Ticket;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ScipioInfoDAO extends BaseScipioInfoDAO {
	
	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public ScipioInfoDAO () {}
	
	public List<ScipioInfo> getScipioInfo() {
		Session session = null;
		
		try {
				session = createNewSession();
				Criteria criteria = session.createCriteria(getReferenceClass());
				return criteria.list();
			} finally {
				closeSession(session);
			}
	}
	
	public ScipioInfo getScipioInfo(Ticket ticket){
		Session session = null;
		
		try {
			session = createNewSession();
			Criteria criteria = session.createCriteria(getReferenceClass());
			criteria.add(Restrictions.eq(ScipioInfo.PROP_TICKET, ticket));
			
			List<ScipioInfo> results = criteria.list();
			
			if (results.isEmpty()) {
				throw new Exception("scipioInfo not found");
			}
			if (results.size() > 1) {
				throw new Exception("more than one scipioInfo found");
			}
			
			return results.get(0);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeSession(session);
		}
	}
}
