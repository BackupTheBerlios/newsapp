package ch.bfh.euro08.hibernate.beans;

public class Order {
	private String id;
	private int quantity;
	private boolean status;
	private int ticket_fkey;
	private int user_fkey;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public int getTicket_fkey() {
		return ticket_fkey;
	}
	public void setTicket_fkey(int ticket_fkey) {
		this.ticket_fkey = ticket_fkey;
	}
	public int getUser_fkey() {
		return user_fkey;
	}
	public void setUser_fkey(int user_fkey) {
		this.user_fkey = user_fkey;
	}
}
