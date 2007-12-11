package ch.bfh.euro08.jsf.beans;

import java.util.Iterator;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.StadeCategory;
import ch.bfh.euro08.util.HibernateUtil;



public class Rollout {



	public Rollout() {
	}

	
	
	public String rollout() {

		List<Match> match = null;
		List<StadeCategory> stadion = null;
		
		Query q = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();


		q = session.createQuery("select from Match");
		match = q.list();
		
		
		for (int i = 0; i < match.size(); i++) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Match: " + match.get(i).getStade_fkey().getId());
			
			// get
			
			
			q = session.createQuery("select from StadeCategory std where std.stade_fkey = :instade_fkey");
			q.setParameter("instade_fkey", match.get(i).getStade_fkey().getId());
			stadion = q.list();
			stadion.get(1).getTickets();
			for (int j = 0; j < stadion.size(); j++) {
				System.out.println("!!!!!!!!!!!!" + i + "!!!!!!!!!!!!!!!!!!Category: " + stadion.get(j).getCategory_fkey().getName() + " Capacity: " + stadion.get(j).getTickets());
			}
			
		}
		session.close();
		
		return "success";
	
	}

	
}
