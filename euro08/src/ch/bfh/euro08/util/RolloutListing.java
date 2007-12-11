package ch.bfh.euro08.util;

import java.sql.Date;

import ch.bfh.euro08.hibernate.beans.Ticket;



public class RolloutListing {
	private String stade;
	private String country;
	private Date datetime;
	private String team1;
	private String team2;
	private String category;
	private int requested_seats;
	private int available_seats;
	
	
	
	public RolloutListing(String stade, String country, Date datetime,
			String team1, String team2, String category, int requested_seats,
			int available_seats) {
		super();
		this.stade = stade;
		this.country = country;
		this.datetime = datetime;
		this.team1 = team1;
		this.team2 = team2;
		this.category = category;
		this.requested_seats = requested_seats;
		this.available_seats = available_seats;
	}
	public String getStade() {
		return stade;
	}
	public void setStade(String stade) {
		this.stade = stade;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public int getRequested_seats() {
		return requested_seats;
	}
	public void setRequested_seats(int requested_seats) {
		this.requested_seats = requested_seats;
	}
	public int getAvailable_seats() {
		return available_seats;
	}
	public void setAvailable_seats(int available_seats) {
		this.available_seats = available_seats;
	}
	


}
