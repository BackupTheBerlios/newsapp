package newsletter.app.business;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Issue {
	private int number;
	private int id;
	private Date publishingDate;
	private Newsletter newsletter;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	
	public Issue(int number, Date publishingDate, Newsletter newsletter){
		this.number = number;
		this.publishingDate = publishingDate;
		this.newsletter = newsletter;
		
		DateFormat df = DateFormat.getInstance(DateFormat.YEAR_FIELD);
		this.id = df.format(publishingDate)*100 + number; 
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
	
}

