package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;

/**
 * Article of an issue
 * @author schnl1@bfh.ch
 * @author zumsr1@bfh.ch
 */
public class Article {
	private String title;
	private String text;
	private Issue issue;
	private int id;
	private Map<String, Author> authorCollection = new HashMap<String, Author>();

	/**
	 * Constructor of an article
	 * @param id id of the article
	 * @param title title of the article
	 * @param text text of the article
	 */
	public Article(int id, String title, String text){
		this.id = id;
		this.title = title;
		this.text = text;
	}
	

	/**
	 * set the issue containing the article
	 * @param issue issue
	 */
	public void setIssue(Issue issue){
		this.issue = issue;
	}
	
	/**
	 * set the title of the article
	 * @param title title of the article
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * set the text of the article
	 * @param text of the article
	 */
	public void setText(String text){
		this.text = text;
	}
	
	/**
	 * get the id of the article
	 * @return id
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * get the title of the article
	 * @return title
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * get the text of the article
	 * @return text
	 */
	public String getText(){
		return this.text;
	}
	
	/**
	 * get the issue containing the article
	 * @return issue
	 */
	public Issue getIssue(){
		return this.issue;
	}

	/**
	 * add an author to the collection
	 * @param author author
	 */
	public void addAuthor(Author author){
		authorCollection.put(author.getEMailAddress(), author);
	}
	
	/**
	 * get all authors that have written the article
	 * @return authors
	 */
	public Map getAuthors(){
		return this.authorCollection;
	}
}