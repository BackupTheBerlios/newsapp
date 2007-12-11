package ch.bfh.euro08.util;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Ordering;
import ch.bfh.euro08.hibernate.beans.Ticket;
import ch.bfh.euro08.hibernate.beans.User;

public class GameListing {
	private Ticket ticket;
	private String stade;
	private String country;
	private Date datetime;
	private String team1;
	private String team2;
	private String category;
	private int price;
	private int orderID;
	private int seat;

	public GameListing(Ticket ticket, String stade, Date datetime,
			String team1, String team2, String category, String country,
			int price, int orderID, int seat) {
		super();
		this.ticket = ticket;
		this.stade = stade;
		this.country = country;
		this.datetime = datetime;
		this.team1 = team1;
		this.team2 = team2;
		this.category = category;
		this.price = price;
		this.orderID = orderID;
		this.seat = seat;
		
		
	}

	public void delete() {

		List<Ordering> order_results = null;
		Query q = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.flush();

		q = session
				.createQuery("select from Ordering ord where ord.status = 1");
		order_results = q.list();

		if (order_results.size() < 1) {

			try {
				Ordering ord = (Ordering) session.get(Ordering.class, orderID);
				session.delete(ord);
				session.getTransaction().commit();
				session.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void request() {

		User managedUserBean = (User) JSFUtil.getManagedObject("user");
		Query q = null;
		List<Ordering> order_results = null;
		int userid = managedUserBean.getId();

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.flush();

		// ORDER
		q = session
				.createQuery("select from Ordering ord where ord.user_fkey = :inuserid");
		q.setParameter("inuserid", userid);
		order_results = q.list();

		if (order_results.size() < 4) {

			try {
				User managedUser = (User) JSFUtil.getManagedObject("user");
				session.save(new Ordering(1, false, ticket, managedUser, 0));
				session.getTransaction().commit();
				session.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String getStade() {
		return stade;
	}

	public void setStade(String stade) {
		this.stade = stade;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int prize) {
		this.price = prize;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getSeat() {
		return seat;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

}
