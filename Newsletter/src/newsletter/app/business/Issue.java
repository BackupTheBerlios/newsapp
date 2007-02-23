package newsletter.app.business;


import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Issue {
	private int number;
	private Date publishingDate;
	private Boolean isOpen = true;
	private Newsletter newsletter;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	private int year;
	
	public Issue(int number, int year, Date publishingDate, Newsletter newsletter){
		this.number = number;
		this.publishingDate = publishingDate;
		this.newsletter = newsletter;
		this.year = year;
	}
	
	public void addArticle(Article article){
		this.articleCollection.put(article.getId(), article);
	}
	
	public int getId(){
		return this.year*100 + this.number;
	}
	
	public int getNumber(){
		return this.number;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public Date getPublishingDate(){
		return this.publishingDate;
	}
	
	public Newsletter getNewsletter(){
		return this.newsletter;
	}
	
	public Map getArticles(){
		return this.articleCollection;
	}
	public Boolean isOpen(){
		return this.isOpen;
	}
	
	public void closeIssue(){
		this.isOpen = false;
	}
	
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

