package ch.bfh.euro08.jsf.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIData;

import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Match;
import ch.bfh.euro08.hibernate.beans.Ordering;
import ch.bfh.euro08.hibernate.beans.Stade;
import ch.bfh.euro08.hibernate.beans.Team;
import ch.bfh.euro08.hibernate.beans.Ticket;
import ch.bfh.euro08.hibernate.beans.User;
import ch.bfh.euro08.util.GameListing;
import ch.bfh.euro08.util.HibernateUtil;
import ch.bfh.euro08.util.JSFUtil;

public class GameRegistry {

	private UIData data = null;
	private UIData data2 = null;
	private UIData wonData = null;
	private int request_quantity;

	public boolean getAnyLeft()
	{
		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		Query q = null;
		List<Ordering> order_results = null;
		int userid = managedUserBean.getId();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// ORDER
		q = session.createQuery("select from Ordering ord where ord.user_fkey = :inuserid and ord.status = 0");
		q.setParameter("inuserid", userid);
		order_results = q.list();
		
		if (order_results.size() < 4)
			return true;
		return false;
	}
	
	public boolean getSomeOrdered() {

		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		Query q = null;
		List<Ordering> order_results = null;
		int userid = managedUserBean.getId();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// ORDER
		q = session.createQuery("select from Ordering ord where ord.status = 1");
		order_results = q.list();
	

		if (order_results.size() < 1)
		{
			// ORDER
			q = session.createQuery("select from Ordering ord where ord.user_fkey = :inuserid");
			q.setParameter("inuserid", userid);
			order_results = q.list();
			
			if(order_results.size() > 1)return true;
		}
			
		return false;
	}
	
	public boolean getNotYetRollout() {

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
	
	public boolean getRollout() {
		return !getNotYetRollout();
	}

	public List getAllGames() {

		List<GameListing> gameList = new ArrayList<GameListing>();
		List<Ticket> ticket_result = null;
		Query q = null;

		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		int userid = managedUserBean.getId();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		q = session.createQuery("select from Ticket tck");
		ticket_result = q.list();

		for (int i = 0; i < ticket_result.size(); i++) {
			System.out.println("found all tickets");
			Ticket ticket = ticket_result.get(i);

			gameList.add(new GameListing(ticket, ticket.getMatch_fkey()
					.getStade_fkey().getName(), ticket.getMatch_fkey()
					.getDatetime(), ticket.getMatch_fkey().getTeam1_fkey()
					.getCountry(), ticket.getMatch_fkey().getTeam2_fkey()
					.getCountry(), ticket.getCategory_fkey().getName(), ticket.getMatch_fkey()
					.getStade_fkey().getCountry(), ticket.getPrice(), 0));
		}
		
		
		Comparator<GameListing> comp =  new Comparator<GameListing>(){
			public int compare(GameListing arg0, GameListing arg1) {
	               Date d1 = arg0.getDatetime();
	               Date d2 = arg1.getDatetime();
	               return d1.compareTo(d2);
			}
		};
	           
		Collections.sort(gameList, comp);
		
		session.close();
		return gameList;
	}

	public List getWonGames() {
		List<GameListing> gameList = new ArrayList<GameListing>();

		Query q = null;
		List<Ordering> order_results = null;

		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		int userid = managedUserBean.getId();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// ORDER
		q = session
				.createQuery("select from Ordering ord where ord.user_fkey = :inuserid and ord.status = 1");
		q.setParameter("inuserid", userid);
		order_results = q.list();

		for (int i = 0; i < order_results.size(); i++) {
			System.out.println("found won tickets");
			Ordering order = order_results.get(i);

			gameList.add(new GameListing(order.getTicket_fkey(), order.getTicket_fkey()
					.getMatch_fkey().getStade_fkey().getName(), order
					.getTicket_fkey().getMatch_fkey().getDatetime(), order
					.getTicket_fkey().getMatch_fkey().getTeam1_fkey()
					.getCountry(), order.getTicket_fkey().getMatch_fkey()
					.getTeam2_fkey().getCountry(), order
					.getTicket_fkey().getCategory_fkey().getName(), order
					.getTicket_fkey().getMatch_fkey().getStade_fkey()
					.getCountry(), order.getTicket_fkey().getPrice(), order.getId()));
		}
		
		Comparator<GameListing> comp =  new Comparator<GameListing>(){
			public int compare(GameListing arg0, GameListing arg1) {
	               Date d1 = arg0.getDatetime();
	               Date d2 = arg1.getDatetime();
	               return d1.compareTo(d2);
			}
		};
	           
		Collections.sort(gameList, comp);
		
		session.close();
		return gameList;
	}
	
	public List getOrderedGames() {
		List<GameListing> gameList = new ArrayList<GameListing>();

		Query q = null;
		List<Ordering> order_results = null;

		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		int userid = managedUserBean.getId();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// ORDER
		q = session
				.createQuery("select from Ordering ord where ord.user_fkey = :inuserid and ord.status = 0");
		q.setParameter("inuserid", userid);
		order_results = q.list();

		for (int i = 0; i < order_results.size(); i++) {
			System.out.println("found ordered tickets");
			Ordering order = order_results.get(i);

			gameList.add(new GameListing(order.getTicket_fkey(), order.getTicket_fkey()
					.getMatch_fkey().getStade_fkey().getName(), order
					.getTicket_fkey().getMatch_fkey().getDatetime(), order
					.getTicket_fkey().getMatch_fkey().getTeam1_fkey()
					.getCountry(), order.getTicket_fkey().getMatch_fkey()
					.getTeam2_fkey().getCountry(), order
					.getTicket_fkey().getCategory_fkey().getName(), order
					.getTicket_fkey().getMatch_fkey().getStade_fkey()
					.getCountry(), order.getTicket_fkey().getPrice(), order.getId()));
		}
		
		Comparator<GameListing> comp =  new Comparator<GameListing>(){
			public int compare(GameListing arg0, GameListing arg1) {
	               Date d1 = arg0.getDatetime();
	               Date d2 = arg1.getDatetime();
	               return d1.compareTo(d2);
			}
		};
	           
		Collections.sort(gameList, comp);
		
		session.close();
		return gameList;
	}

	public UIData getData() {
		return data;
	}

	public void setData(UIData data) {
		this.data = data;
	}

	public UIData getData2() {
		return data2;
	}

	public void setData2(UIData data2) {
		this.data2 = data2;
	}

	public int getRequest_quantity() {
		return request_quantity;
	}

	public void setRequest_quantity(int request_quantity) {
		this.request_quantity = request_quantity;
	}

	public UIData getWonData() {
		return wonData;
	}

	public void setWonData(UIData wonData) {
		this.wonData = wonData;
	}


}
