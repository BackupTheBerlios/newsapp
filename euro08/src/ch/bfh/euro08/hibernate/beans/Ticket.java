package ch.bfh.euro08.hibernate.beans;

public class Ticket {
	private int id;
	private int price;
	private Match match_fkey;
	private Category category_fkey;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Match getMatch_fkey() {
		return match_fkey;
	}
	public void setMatch_fkey(Match match_fkey) {
		this.match_fkey = match_fkey;
	}
	public Category getCategory_fkey() {
		return category_fkey;
	}
	public void setCategory_fkey(Category category_fkey) {
		this.category_fkey = category_fkey;
	}
	
	
}
