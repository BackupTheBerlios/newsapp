package newsletter.app.business;

import java.util.ArrayList;
import java.util.List;

public class NewsletterController {
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	
	public String newNewsletter(String name, String description, int periodicity){
		return newsletterCollection.add(name, description, periodicity);
	}
	
	public List getAllNewsletter(){
		return new ArrayList();
	}
	
	public String getDescription(String newsletterName){
		return newsletterCollection.getNewsletter(newsletterName).getDescription();
	}
	
	public int getPeriodicity(String newsletterName){
		return newsletterCollection.getNewsletter(newsletterName).getPeriodicity();
	}
	
	
}
