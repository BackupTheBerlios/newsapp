package newsletter.app.business;

public class SubscribeController {
	private SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	
	public void subscribe(String eMailAddress, String newsletterName){
		Newsletter newsletter = newsletterCollection.getNewsletter(newsletterName);
		Subscriber subscriber = subscriberCollection.getSubscriber(eMailAddress);

		newsletter.subscribe(subscriber);
		subscriber.subscribe(newsletter);
	}
	
	public void unsubscribe(String eMailAddress, String newsletterName){
		Newsletter newsletter = newsletterCollection.getNewsletter(newsletterName);
		Subscriber subscriber = subscriberCollection.getSubscriber(eMailAddress);

		newsletter.unsubscribe(subscriber);
		subscriber.unsubscribe(newsletter);
	}

}
