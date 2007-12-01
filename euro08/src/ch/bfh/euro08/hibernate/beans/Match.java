package ch.bfh.euro08.hibernate.beans;

import java.sql.Date;

public class Match {
	private int id;
	private int stade_fkey;
	private Date datetime;
	private int team1_fkey;
	private int team2_fkey;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStade_fkey() {
		return stade_fkey;
	}
	public void setStade_fkey(int stade_fkey) {
		this.stade_fkey = stade_fkey;
	}
	public String getDatetime() {
		return datetime.toString();
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public int getTeam1_fkey() {
		return team1_fkey;
	}
	public void setTeam1_fkey(int team1_fkey) {
		this.team1_fkey = team1_fkey;
	}
	public int getTeam2_fkey() {
		return team2_fkey;
	}
	public void setTeam2_fkey(int team2_fkey) {
		this.team2_fkey = team2_fkey;
	}
}