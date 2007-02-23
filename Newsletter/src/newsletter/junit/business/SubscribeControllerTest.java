package newsletter.junit.business;

import newsletter.app.business.NewsletterController;
import newsletter.app.business.RegisterController;
import newsletter.app.business.SubscribeController;
import junit.framework.TestCase;

/**
 * test class for SubscribeController
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class SubscribeControllerTest extends TestCase{
	/**
	 * Tests the subscribe function
	 */
	public void testSubscribe(){
		SubscribeController subscribeController = new SubscribeController();
		NewsletterController newsletterController = new NewsletterController();
		RegisterController registerController = new RegisterController();
		
		registerController.register("zumsr1@bfh.ch", "myPassword");
		newsletterController.newNewsletter("BFH Newsletter", "blablabla", 6);
		subscribeController.subscribe("zumsr1@bfh.ch", "BFH Newsletter");
		
		assertTrue(subscribeController.hasNewsletterSubscription("zumsr1@bfh.ch", "BFH Newsletter"));
	}

	/**
	 * Tests the unsubscribe function
	 */
	public void testUnsubscribe(){
		SubscribeController subscribeController = new SubscribeController();
		NewsletterController newsletterController = new NewsletterController();
		RegisterController registerController = new RegisterController();
		
		registerController.register("zumsr1@bfh.ch", "myPassword");
		newsletterController.newNewsletter("BFH Newsletter", "blablabla", 6);
		subscribeController.subscribe("zumsr1@bfh.ch", "BFH Newsletter");
		
		assertTrue(subscribeController.hasNewsletterSubscription("zumsr1@bfh.ch", "BFH Newsletter"));
		subscribeController.unsubscribe("zumsr1@bfh.ch", "BFH Newsletter");
		assertFalse(subscribeController.hasNewsletterSubscription("zumsr1@bfh.ch", "BFH Newsletter"));
	}	
}
