package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;

public class Article {
	private String title;
	private String text;
	private Issue issue;
	private int id;
	private static int actId = 0;
	private Map<Integer, Author> authorCollection = new HashMap<Integer, Author>();

	public Article(String title, String text){
		this.id = Article.createId();
		this.title = title;
		this.text = text;
	}
	
	private static synchronized int createId() {
		return ++actId;
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
	
	public int getId(){
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