package newsletter.app.business;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * A newsletter contains any issues.
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class Newsletter {
	private String name;
	private String description;
	private int periodicitiy;
	private Map<String, Subscriber> subscriberCollection = new HashMap<String, Subscriber>();
	private Map<Integer, Issue> issueCollection = new HashMap<Integer, Issue>();
	private Map<Integer, Article> unlinkedArticleCollection = new HashMap<Integer, Article>();
	private Map<Integer, Article> linkedArticleCollection = new HashMap<Integer, Article>();
	private Issue openIssue;
		
	/**
	 * Constructor
	 * @param name of the newsletter
	 * @param description of the newsletter
	 * @param periodicity (how many issues per year)
	 */
	public Newsletter(String name, String description, Integer periodicity){
		this.name = name;
		this.description = description;
		this.periodicitiy = periodicity;
	}
	
	/**
	 * returns the name of the newsletter
	 * @return name of the newsletter
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * returns the description of the newsletter
	 * @return description of the newsletter
	 */
	public String getDescription(){
		return this.description;
	}
	
	
	/**
	 * returns the periodicity
	 * @return how many issues per year
	 */
	public int getPeriodicity(){
		return this.periodicitiy;
	}
	
	
	/**
	 * adds a subscriber to its subscriberlist
	 * @param subscriber
	 */
	public void subscribe(Subscriber subscriber){
		if (!hasNewsletterSubscription(subscriber)){
			subscriberCollection.put(subscriber.getEMailAddress(), subscriber);
		}
	}
	
	/**
	 * removes a subscriber from its subscriberlist
	 * @param subscriber
	 */
	public void unsubscribe(Subscriber subscriber){
		if (hasNewsletterSubscription(subscriber)){
			subscriberCollection.remove(subscriber);
		}
	}
	
	
	/** has the subscriber a subscription for this newsletter
	 * @param subscriber
	 * @return
	 */
	private boolean hasNewsletterSubscription(Subscriber subscriber){
		return subscriberCollection.containsValue(subscriber);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	/**
	 * changes the periodicity
	 * @param periodicity (how many issues per year)
	 */
	public void setPeriodicity(int periodicity){
		this.periodicitiy = periodicity;
	}
	
	public void addArticle(Article article){
		this.unlinkedArticleCollection.put(article.getId(), article);
	}
	
	public void setArticleToOpenIssue(int articleId){
		Article article = this.unlinkedArticleCollection.get(articleId);
		
		if (article != null){
			this.openIssue.addArticle(article);
			this.unlinkedArticleCollection.remove(article);
			this.linkedArticleCollection.put(article.getId(), article);
		}
	}
	
	public Issue compileIssueAndCreateNew(int year, Date publishingDate){
		this.openIssue.closeIssue();
		
		
		int number;
		if (year == this.openIssue.getYear()){
			number = this.openIssue.getNumber();
			number++;
		}else{
			number = 1;
		}
	
		Issue issue = new Issue(number, year, publishingDate, this);
		this.issueCollection.put(issue.getId(), issue);
		this.openIssue = issue;
		return issue;
	}
	
	public Issue getOpenIssue(){
		return this.openIssue;
	}
	
	public Map getIssues(){
		return this.issueCollection;
	}
	
	public Article getArticle(int articleId){
		return this.linkedArticleCollection.get(articleId);
	}
}
