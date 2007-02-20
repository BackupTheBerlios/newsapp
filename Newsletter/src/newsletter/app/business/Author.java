package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;

public class Author {
	private String name;
	private String firstName;
	private int id;
	private static int actId = 0;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	
	public Author(String name, String firstName){
		this.name = name;
		this.firstName = firstName;
		this.id = createId();
	}
	private static synchronized int createId() {
		return ++actId;
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

}
