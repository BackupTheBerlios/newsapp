package ch.bfh.euro08.jsf.beans;

import java.util.Iterator;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.Ordering;
import ch.bfh.euro08.hibernate.beans.StadeCategory;
import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.HibernateUtil;
import ch.bfh.euro08.util.JSFUtil;



public class Rollout {



	public Rollout() {
	}
	
	public boolean getNotDone() {

		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		Query q = null;
		List<Ordering> order_results = null;
		int userid = managedUserBean.getId();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// ORDER
		q = session.createQuery("select from Ordering ord where ord.status = 1");
		order_results = q.list();
	

		if (order_results.size() > 0)
			return false;
		return true;
	}
	
	public boolean getDone() {

		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		Query q = null;
		List<Ordering> order_results = null;
		int userid = managedUserBean.getId();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// ORDER
		q = session.createQuery("select from Ordering ord where ord.status = 1");
		order_results = q.list();
	

		if (order_results.size() > 0)
			return true;
		return false;
	}
	
	public String rollback() {
		List<Ordering> order = null;
		
		Query q = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		q = session.createQuery("select from Ordering ord order by ticket_fkey asc");
		order = q.list();
		
		for (int i = 0; i < order.size(); i++) {
			order.get(i).setSeat(0);
			order.get(i).setStatus(false);
			session.update(order.get(i));
		}
		session.getTransaction().commit();
		return "success";
	}
	
	public String rollout() {
		List<Ordering> order = null;
		List<StadeCategory> stadion = null;
		
		Query q = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		q = session.createQuery("select from Ordering ord order by ticket_fkey asc");
		order = q.list();
		
		double orig_step = 0;
		double step = 0;
		int available = 0;
		int seatnumber = 1;
		int temp = 0;
		for (int i = 0; i < order.size(); i++) {
			System.out.println("EENNTTEERRIINNGG");
			
			// If new order id
			if (temp != order.get(i).getTicket_fkey().getId()) {
				
				temp = order.get(i).getTicket_fkey().getId();
				
				// SEATS 
				List<StadeCategory> stadecategory_result = null;
				q = session.createQuery("select from StadeCategory std where std.stade_fkey = :instade and std.category_fkey = :incat");
				q.setParameter("instade", order.get(i).getTicket_fkey().getMatch_fkey().getStade_fkey().getId());
				q.setParameter("incat", order.get(i).getTicket_fkey().getCategory_fkey().getId());
				stadecategory_result = q.list();
				StadeCategory std = stadecategory_result.get(0);
				available = std.getTickets();
				seatnumber = 1;
				
				// REQUESTED 
				List<Ordering> order_result = null;
				q = session.createQuery("select from Ordering ord where ord.ticket_fkey = :inticket");
				q.setParameter("inticket", order.get(i).getTicket_fkey().getId());
				order_result = q.list();
				int requested = 0;
				for (int j = 0; j < order_result.size(); j++) {
					requested++;
				}
				
				orig_step = (double)requested / (double)available;
				
				System.out.println("Ava: " + available + ", Req: " + requested + ", Step: " + orig_step + ", Temp: " + temp);
			}
			
			if (available > 0 && step <= 1.0) {
				System.out.println("EENNTTEERRIINNGG 22");
				order.get(i).setSeat(seatnumber);
				seatnumber++;
				available--;
			
				order.get(i).setStatus(true);
				
				session.update(order.get(i));
				step = orig_step;
			}else{
				step--;
			}
		}
		session.getTransaction().commit();
		
		return "success";
	
	}

	
}
