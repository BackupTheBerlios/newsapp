package ch.bfh.euro08.hibernate.beans;

import java.sql.Date;

public class Match {
	
	private int id;
	private Stade stade_fkey;
	private Date datetime;
	private Team team1_fkey;
	private Team team2_fkey;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Stade getStade_fkey() {
		return stade_fkey;
	}
	public void setStade_fkey(Stade stade_fkey) {
		this.stade_fkey = stade_fkey;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Team getTeam1_fkey() {
		return team1_fkey;
	}
	public void setTeam1_fkey(Team team1_fkey) {
		this.team1_fkey = team1_fkey;
	}
	public Team getTeam2_fkey() {
		return team2_fkey;
	}
	public void setTeam2_fkey(Team team2_fkey) {
		this.team2_fkey = team2_fkey;
	}
	

	
}