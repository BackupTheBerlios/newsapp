package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;

public class Author {
	private String name;
	private String firstName;
	private int id;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	
	public Author(int id, String name, String firstName){
		this.name = name;
		this.firstName = firstName;
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public Map getArticles(){
		return articleCollection;
	}
	
	public boolean equals(Object obj){
		if(!(obj instanceof Author)) return false;
		
		Author author = (Author) obj;
		if(author.getId() != this.getId()) return false;
		if(author.getFirstName().equalsIgnoreCase(this.getFirstName())) return false;
		if(author.getName().equalsIgnoreCase(this.getName())) return false;
		
		return true;
	}

}
