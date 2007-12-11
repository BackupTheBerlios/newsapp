package ch.bfh.euro08.hibernate.beans;

public class Ordering {
	private int id;
	private int quantity;
	private boolean status;
	private Ticket ticket_fkey;
	private User user_fkey;
	
	public Ordering(){}
	
	public Ordering(int quantity, boolean status, Ticket ticket_fkey,
			User user_fkey) {
		super();
		this.quantity = quantity;
		this.status = status;
		this.ticket_fkey = ticket_fkey;
		this.user_fkey = user_fkey;
	}
	public Ordering(int id, int quantity, boolean status, Ticket ticket_fkey,
			User user_fkey) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.status = status;
		this.ticket_fkey = ticket_fkey;
		this.user_fkey = user_fkey;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public User getUser_fkey() {
		return user_fkey;
	}
	public void setUser_fkey(User user_fkey) {
		this.user_fkey = user_fkey;
	}
	public Ticket getTicket_fkey() {
		return ticket_fkey;
	}
	public void setTicket_fkey(Ticket ticket_fkey) {
		this.ticket_fkey = ticket_fkey;
	}

}
