package newsletter.app.business;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Issue {
	private int number;
	private int year;
	private int id;
	private Date publishingDate;
	private Newsletter newsletter;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	
	public Issue(int number, int year, Date publishingDate, Newsletter newsletter){
		this.number = number;
		this.year = year;
		this.publishingDate = publishingDate;
		this.newsletter = newsletter;
		this.id = year*100 + number; 
	}
	
	public void addArticle(Article article){
		this.articleCollection.put(article.getId(), article);
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getNumber(){
		return this.number;
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
	
}

