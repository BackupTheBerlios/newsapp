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
	private static int articleId;

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
		articleId = 1;
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
			System.out.println("remove Subscriber");
			subscriberCollection.remove(subscriber.getEMailAddress());
		}
	}
	
	
	/** has the subscriber a subscription for this newsletter
	 * @param subscriber
	 * @return has a subscriber a subscription for this newsletter
	 */
	public boolean hasNewsletterSubscription(Subscriber subscriber){
		return subscriberCollection.containsValue(subscriber);
	}
	
	/**
	 * changes the name of this newsletter
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * changes the description of this newsletter
	 * @param description
	 */
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
	
	/**
	 * adds an article to this newsletter, the article isn't linked with an issue
	 * @param title title of the article
	 * @param text text of the article
	 */
	public Article addArticle(String title, String text){
		Article article = new Article(articleId, title, text);
		this.unlinkedArticleCollection.put(article.getId(), article);
		articleId++;
		return article;
	}
	
	/**
	 * link an article with the open issue
	 * @param articleId
	 */
	public void setArticleToOpenIssue(int articleId){
		Article article = this.unlinkedArticleCollection.get(articleId);
		
		if (article != null){
			this.openIssue.addArticle(article);
			this.unlinkedArticleCollection.remove(article.getId());
			this.linkedArticleCollection.put(article.getId(), article);
		}
	}
	
	/**
	 * compile issue
	 * @param year
	 * @param publishingDate
	 * @return the new generated issue
	 */
	public Issue compileIssueAndCreateNew(int year, Date publishingDate){
		int number;
		if (this.openIssue != null){
			this.openIssue.closeIssue();
			System.out.println("compile issue and send mails");
		
			if (year == this.openIssue.getYear()){
				number = this.openIssue.getNumber();
				number++;
			}else{
				number = 1;
			}
		}else{
			number = 1;
		}
		
	
		Issue issue = new Issue(number, year, publishingDate, this);
		this.issueCollection.put(issue.getId(), issue);
		this.openIssue = issue;
		return issue;
	}
	
	/**
	 * returns the open issue
	 * @return open issue
	 */
	public Issue getOpenIssue(){
		return this.openIssue;
	}
	
	/**
	 * gets all issues of this newsletter
	 * @return MAp with all issues
	 */
	public Map getIssues(){
		return this.issueCollection;
	}
	
	/**
	 * gets an Article from id
	 * @param articleId
	 * @return article
	 */
	public Article getArticle(int articleId){
		if (this.linkedArticleCollection.get(articleId) == null){
			return this.unlinkedArticleCollection.get(articleId);
		}else{
			return this.linkedArticleCollection.get(articleId);
		}
	}
	
	public Map getUnlinkedArticles(){
		return unlinkedArticleCollection;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((description == null) ? 0 : description.hashCode());
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
		result = PRIME * result + periodicitiy;
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
		final Newsletter other = (Newsletter) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (periodicitiy != other.periodicitiy)
			return false;
		return true;
	}
	
	
}
