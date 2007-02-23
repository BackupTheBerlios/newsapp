package newsletter.app.business;


import java.util.Date;
import java.util.Map;
import java.util.HashMap;

/**
 * Issue
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 */
public class Issue {
	private int number;
	private Date publishingDate;
	private Boolean isOpen = true;
	private Newsletter newsletter;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	private int year;
	
	/**
	 * Constructor
	 * @param number 
	 * @param year
	 * @param publishingDate
	 * @param newsletter
	 */
	public Issue(int number, int year, Date publishingDate, Newsletter newsletter){
		this.number = number;
		this.publishingDate = publishingDate;
		this.newsletter = newsletter;
		this.year = year;
	}
	
	/**
	 * link an article with the issue
	 * @param article
	 */
	public void addArticle(Article article){
		this.articleCollection.put(article.getId(), article);
	}
	
	
	/**
	 * gets the id of the issue
	 * @return id of the issue
	 */
	public int getId(){
		return this.year*100 + this.number;
	}
	
	/**
	 * returns the number of this issue
	 * @return number of the issue
	 */
	public int getNumber(){
		return this.number;
	}
	
	
	/**
	 * returns the year of this issue
	 * @return year of the issue
	 */
	public int getYear(){
		return this.year;
	}
	
	
	/**
	 * returns publishing date
	 * @return publishing date
	 */
	public Date getPublishingDate(){
		return this.publishingDate;
	}
	
	
	/**
	 * which newsletter contains this issue?
	 * @return newsletter
	 */
	public Newsletter getNewsletter(){
		return this.newsletter;
	}
	
	
	/**
	 * returns every linked article of this issue
	 * @return Map of every acrticle this issue contains
	 */
	public Map getArticles(){
		return this.articleCollection;
	}
	
	
	/**
	 * is the issue open
	 * @return boolean, is the issue open?
	 */
	public Boolean isOpen(){
		return this.isOpen;
	}
	
	/**
	 * close the issue
	 */
	public void closeIssue(){
		this.isOpen = false;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof Issue)) return false;
	
		Issue issue = (Issue) obj;
		
		if(!(issue.getId() == this.getId())) return false;
		if(!issue.getPublishingDate().equals(this.getPublishingDate())) return false;
		if(!issue.getNewsletter().equals(this.getNewsletter())) return false;
		if(!issue.getArticles().equals(this.getArticles())) return false;
		
		return true;
	}
	
}

