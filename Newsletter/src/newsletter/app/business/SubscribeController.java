package newsletter.app.business;

/**
 * the SubscriberController handles the interactions between GUI and Systemobjects
 * @author Zumsr1@bfh.ch
 * @author Schnly@bfh.ch
 *
 */
public class SubscribeController {
	private SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	
	
	/**
	 * subscribe to a newsletter
	 * @param eMailAddress
	 * @param newsletterName
	 */
	public void subscribe(String eMailAddress, String newsletterName){
		Newsletter newsletter = newsletterCollection.getNewsletter(newsletterName);
		Subscriber subscriber = subscriberCollection.getSubscriber(eMailAddress);

		newsletter.subscribe(subscriber);
		subscriber.subscribe(newsletter);
	}
	
	
	/**
	 * unsubscribe from newsletter
	 * @param eMailAddress
	 * @param newsletterName
	 */
	public void unsubscribe(String eMailAddress, String newsletterName){
		Newsletter newsletter = newsletterCollection.getNewsletter(newsletterName);
		Subscriber subscriber = subscriberCollection.getSubscriber(eMailAddress);

		newsletter.unsubscribe(subscriber);
		subscriber.unsubscribe(newsletter);
	}

}