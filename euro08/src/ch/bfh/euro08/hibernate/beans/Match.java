package ch.bfh.euro08.hibernate.beans;

import java.sql.Date;

public class Match {
	
	private int id;
	private Stade stade;
	private Date datetime;
	private Team team1;
	private Team team2;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Stade getStade() {
		return stade;
	}
	public void setStade(Stade stade) {
		this.stade = stade;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	
}