package newsletter.app.business;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Issue {
	private int number;
	private Date publishingDate;
	private Newsletter newsletter;
	private Map<String, Article> articleCollection = new HashMap<String, Article>();
	
	public Issue(int number, Date publishingDate, Newsletter newsletter){
		this.number = number;
		this.publishingDate = publishingDate;
		this.newsletter = newsletter;
	}
	
	
}
