package newsletter.app.business;

public class SubscribeController {
	private SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	
	public void subscribe(String eMailAddress, String newsletterName){
		Newsletter newsletter = newsletterCollection.getNewsletter(newsletterName);
	}

}
