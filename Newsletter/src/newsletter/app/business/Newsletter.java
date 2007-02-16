package newsletter.app.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Newsletter {
	private String name;
	private String description;
	private int periodicitiy;
	private Map<String, Subscriber> subscriberCollection = new HashMap<String, Subscriber>();
	private Map<Integer, Issue> issueCollection = new HashMap<Integer, Issue>();
	private List<Article> unlinkedArticleCollection = new ArrayList<Article>();
	private Issue actIssue;
		
	public Newsletter(String name, String description, Integer periodicity){
		this.name = name;
		this.description = description;
		this.periodicitiy = periodicity;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public int getPeriodicity(){
		return this.periodicitiy;
	}
	
	public void subscribe(Subscriber subscriber){
		if (!hasNewsletterSubscription(subscriber)){
			subscriberCollection.put(subscriber.getEMailAddress(), subscriber);
		}
	}
	
	public void unsubscribe(Subscriber subscriber){
		if (hasNewsletterSubscription(subscriber)){
			subscriberCollection.remove(subscriber);
		}
	}
	
	private boolean hasNewsletterSubscription(Subscriber subscriber){
		return subscriberCollection.containsValue(subscriber);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setPeriodicity(int periodicity){
		this.periodicitiy = periodicity;
	}
	
	public void addArticle(Article article){
		this.unlinkedArticleCollection.add(article);
	}
	
	public Issue newIssue(int number, int year, Date publishingDate){
		Issue issue = new Issue(number, year, publishingDate, this);
		this.issueCollection.put(issue.getId(), issue);
		this.actIssue = issue;
		return issue;
	}
	
	public Issue getActIssue(){
		return this.actIssue;
	}
	
	public Map getIssues(){
		return this.issueCollection;
	}
}
