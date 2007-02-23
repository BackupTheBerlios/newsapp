package newsletter.junit.business;

import newsletter.app.business.Newsletter;
import newsletter.app.business.Subscriber;
import junit.framework.TestCase;

/**
 * test class for Subscriber
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class SubscriberTest extends TestCase{
	/**
	 * Tests the subscribe function
	 */
	public void testSubscribe(){
		Subscriber subscriber = new Subscriber("zumsr1@bfh.ch", "myPassword");
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		
		subscriber.subscribe(newsletter);
		assertTrue(subscriber.hasNewsletterSubscription(newsletter));
	}

	/**
	 * Tests the unsubscribe function
	 */
	public void testUnsubscribe(){
		Subscriber subscriber = new Subscriber("zumsr1@bfh.ch", "myPassword");
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		
		subscriber.subscribe(newsletter);
		subscriber.unsubscribe(newsletter);
		assertFalse(subscriber.hasNewsletterSubscription(newsletter));
	}	
}
