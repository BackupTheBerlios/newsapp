package ch.bfh.euro08.jsf.beans;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import ch.bfh.euro08.hibernate.beans.Ordering;
import ch.bfh.euro08.hibernate.beans.StadeCategory;
import ch.bfh.euro08.util.HibernateUtil;

public class Rollout {

	public Rollout() {
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
			
			// If the Sector, Stadion or Game changes
			if (temp != order.get(i).getTicket_fkey().getId()) {
				temp = order.get(i).getTicket_fkey().getId();
				
				// Ruft die Anzahlt der freien SEATS für den aktuellen Match, Stadion, Kategorie ab
				List<StadeCategory> stadecategory_result = null;
				q = session.createQuery("select from StadeCategory std where std.stade_fkey = :instade and std.category_fkey = :incat");
				q.setParameter("instade", order.get(i).getTicket_fkey().getMatch_fkey().getStade_fkey().getId());
				q.setParameter("incat", order.get(i).getTicket_fkey().getCategory_fkey().getId());
				stadecategory_result = q.list();
				StadeCategory std = stadecategory_result.get(0);
				available = std.getTickets();
				seatnumber = 1;
				
				// Ruft die Anzahl der Tickets ab die REQUESTED wurden
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
				// Setze die Sitzplatznummer in die Order, diese Order hat ein Ticket erhalten
				order.get(i).setSeat(seatnumber);
				seatnumber++;
				available--;
				
				// Diese Order hat ein Tickets erhalten
				order.get(i).setStatus(true);
				
				session.update(order.get(i));
				step = orig_step;
			} else {
				step--;
			}
		}
		session.getTransaction().commit();
		
		return "success";
	}

	// Methode zum Anzeigen des Rolloutbuttons. Wird über rendered="#{rollout.notDone}" gesteuert
	public boolean getNotDone() {
		Query q = null;
		List<Ordering> order_results = null;
	
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// Liest alle Orderings aus, und prüft ob es bereits zugeteilte tickets gibt
		q = session.createQuery("select from Ordering ord where ord.status = 1");
		order_results = q.list();
	
		if (order_results.size() > 0)
			return false;
		return true;
	}
	
	// Methode zum Anzeigen des Rolloutbuttons. Wird über rendered="#{rollout.done}" gesteuert
	public boolean getDone() {
		Query q = null;
		List<Ordering> order_results = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// Liest alle Orderings aus, und prüft ob es bereits zugeteilte tickets gibt
		q = session.createQuery("select from Ordering ord where ord.status = 1");
		order_results = q.list();
	
		if (order_results.size() > 0)
			return true;
		return false;
	}
	
}
