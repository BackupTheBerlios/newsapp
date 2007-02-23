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


	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + id;
		result = PRIME * result + ((text == null) ? 0 : text.hashCode());
		result = PRIME * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Article other = (Article) obj;
		if (id != other.id)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}