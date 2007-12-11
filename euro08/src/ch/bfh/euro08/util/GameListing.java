package ch.bfh.euro08.util;

import java.sql.Date;

import org.hibernate.Session;

import ch.bfh.euro08.hibernate.beans.Ordering;


public class GameListing {
	private int id;
	private String stade;
	private String country;
	private Date datetime;
	private String team1;
	private String team2;
	private int ticketcount;
	private String category;
	private int price;
	private Ordering order = new Ordering();

	public GameListing(int id, String stade, Date datetime, String team1,
			String team2, int ticketcount, String category, String country,
			int price) {
		super();
		this.id = id;
		this.stade = stade;
		this.country = country;
		this.datetime = datetime;
		this.team1 = team1;
		this.team2 = team2;
		this.ticketcount = ticketcount;
		this.category = category;
		this.price = price;
	}

	public void delete() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			session.delete(order);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void request() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		try {
			session.save(order);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getTicketcount() {
		return ticketcount;
	}

	public void setTicketcount(int ticketcount) {
		this.ticketcount = ticketcount;
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

}
