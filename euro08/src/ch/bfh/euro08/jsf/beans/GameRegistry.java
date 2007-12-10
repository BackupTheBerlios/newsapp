package ch.bfh.euro08.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.Order;
import ch.bfh.euro08.hibernate.beans.Ticket;
import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.GameListing;
import ch.bfh.euro08.util.HibernateUtil;
import ch.bfh.euro08.util.JSFUtil;

public class GameRegistry {

	public List getTrainingEventsForUser()
	{
		List<GameListing> gameList = new ArrayList<GameListing>();
		
		Query q = null;
		List<Order> order_results = null;
		List<Ticket> ticket_results = null;
		List<Match> match_results = null;
		
		  List userEventList;
		  User managedUserBean = 
		     (User)JSFUtil.getManagedObject("UserBean");  
		     
		  int userid = managedUserBean.getId();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		q = session.createQuery("SELECT FROM `order` WHERE order.user_fkey = :inuserid");
		q.setParameter("inuserid", userid);
		order_results = q.list();

		for (int i = 0; i < order_results.size(); i++) {
			Order order = order_results.get(i);
			
			q = session.createQuery("SELECT FROM `order` WHERE order.user_fkey = :inuserid");
			q.setParameter("inuserid", userid);
			ticket_results = q.list();
			
		}
		
		session.close();
		return gameList;
	}

	public Match getTrainingEventById(int id) {

		Match match = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		match = (Match) session.get(Match.class, new Long(id));
		session.close();
		return match;

	}

	public List getAllEvents() {
		System.out.println("geteventlist!");
		List elist = new ArrayList();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		elist = session.createCriteria(Match.class).list();

		session.close();
		return elist;
	}
}
