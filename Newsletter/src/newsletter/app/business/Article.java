package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;

public class Article {
	private String title;
	private String text;
	private Issue issue;
	private String emailaddress;
	private Map<Integer, Author> authorCollection = new HashMap<Integer, Author>();

	public Article(String emailaddress, String title, String text){
		this.emailaddress = emailaddress;
		this.title = title;
		this.text = text;
	}
	

	public void setIssue(Issue issue){
		this.issue = issue;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public int getEmailAddress(){
		return this.id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getText(){
		return this.text;
	}
	
	public Issue getIssue(){
		return this.issue;
	}

	public void addAuthor(Author author){
		authorCollection.put(author.getId(), author);
	}
	
	public Map getAuthors(){
		return this.authorCollection;
	}
}