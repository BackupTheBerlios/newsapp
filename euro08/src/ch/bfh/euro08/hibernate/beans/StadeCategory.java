package ch.bfh.euro08.hibernate.beans;

public class StadeCategory {
	private int id;
	private String description;
	private int tickets;
	private Category category_fkey;
	private Stade stade_fkey;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public Category getCategory_fkey() {
		return category_fkey;
	}
	public void setCategory_fkey(Category category_fkey) {
		this.category_fkey = category_fkey;
	}
	public Stade getStade_fkey() {
		return stade_fkey;
	}
	public void setStade_fkey(Stade stade_fkey) {
		this.stade_fkey = stade_fkey;
	}
	
	
}
