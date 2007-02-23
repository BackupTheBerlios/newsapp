package newsletter.app.business;

/**
 * the SubscribeController handles the interactions between GUI and Systemobjects 
 * for subscription and unsubscription.
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
	
	/**
	 * chechs, if already a subscription exists
	 * @param eMailAddress
	 * @param newsletterName
	 * @return boolean, exists a subscription?
	 */
	public boolean hasNewsletterSubscription(String eMailAddress, String newsletterName){
		Newsletter newsletter = newsletterCollection.getNewsletter(newsletterName);
		Subscriber subscriber = subscriberCollection.getSubscriber(eMailAddress);

		return newsletter.hasNewsletterSubscription(subscriber);
	}

}