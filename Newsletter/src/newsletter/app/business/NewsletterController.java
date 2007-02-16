package newsletter.app.business;

public class NewsletterController {
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	
	public String newNewsletter(String name, String description, int periodicity){
		return newsletterCollection.add(name, description, periodicity);
	}
}
