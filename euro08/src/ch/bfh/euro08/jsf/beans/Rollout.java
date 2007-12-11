package ch.bfh.euro08.jsf.beans;

import java.util.Iterator;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.Ordering;
import ch.bfh.euro08.hibernate.beans.StadeCategory;
import ch.bfh.euro08.util.HibernateUtil;



public class Rollout {



	public Rollout() {
	}

	
	
	public String rollout() {
		List<Ordering> order = null;
		List<StadeCategory> stadion = null;
		
		Query q = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		q = session.createQuery("select from Ordering ord Order by ticket_fkey asc");
		order = q.list();
		
		int avaiable = "count of avaiable tickets";
		int rolledOut = 0;
		int seatnummber = 1;
		int temp = order.get(0).getTicket_fkey().getId();
		for (int i = 0; i < order.size(); i++) {
			
			// If new order id
			if (temp != order.get(i).getTicket_fkey().getId()) {
				avaiable = "reset avaiable count";
				rolledOut = 0;
				seatnummber = 1;
				temp = order.get(i).getTicket_fkey().getId();
			}
			
			if (avaiable > 0) {
				order.get(i).setSeat(seatnummber);
				order.get(i).setStatus(true);
			} else {
			
			avaiable--;
			seatnummber++;
			rolledOut++;
			
		
		}
		session.close();
		
		/*
		List<Match> match = null;
		List<StadeCategory> stadion = null;
		
		Query q = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		q = session.createQuery("select from Match");
		match = q.list();
		
		
		
		// REQUESTED 
		q = session.createQuery("select SUM(ord.ticket_fkey) as sum from ordering ord where ord.ticket_fkey = :inticket group by ord.ticket_fkey ");
		q.setParameter("inticket", ticket.getId());
		order_result = q.list();
		int requested = order_result.get(0);
		
		
		// SEATS 
		q = session.createQuery("select * from StadeCategory std where std.stade_fkey = :instade and std.category_fkey = :incat");
		q.setParameter("instade", ticket.getMatch_fkey().getStade_fkey().getId());
		q.setParameter("incat", ticket.getCategory_fkey().getId());
		order_result = q.list();
		int seats = order_result.get(0);
		
		
		for (int i = 0; i < match.size(); i++) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Match: " + match.get(i).getStade_fkey().getId());
				
			q = session.createQuery("select from StadeCategory std where std.stade_fkey = :instade_fkey");
			q.setParameter("instade_fkey", match.get(i).getStade_fkey().getId());
			stadion = q.list();
			stadion.get(1).getTickets();
			
			for (int j = 0; j < stadion.size(); j++) {
				
				
				
				stadion.get(i).getStade_fkey().getId();
				System.out.println("!!!!!!!!!!!!Match: " + match.get(i).getId() + " Category: " + stadion.get(j).getCategory_fkey().getName() + " Capacity: " + stadion.get(j).getTickets());
			}
			
		
			
			
		}
		session.close();
		*/
		return "success";
	
	}

	
}
