package newsletter.junit.business;

import junit.framework.TestCase;
import newsletter.app.business.*;


/**
 * Test class for the OnlineSubscriberCollection
 * @author schnl1@bfh.ch
 * @author zumsr1@bfh.ch
 */
public class OnlineSubscriberCollectionTest extends TestCase{

	/**
	 * test the login function
	 */
	public void testLogin(){
		OnlineSubscriberCollection onlineSubscriberCollection = OnlineSubscriberCollection.getInstance();
		Subscriber subscriber = new Subscriber("Zumsr1@bfh.ch","password");
		onlineSubscriberCollection.login(subscriber);
		
		assertTrue(onlineSubscriberCollection.isAlreadyLoggedIn(subscriber));
		onlineSubscriberCollection.clear();
	}
	
	/**
	 * test the logout function
	 */
	public void testLogout(){
		OnlineSubscriberCollection onlineSubscriberCollection = OnlineSubscriberCollection.getInstance();
		Subscriber subscriber = new Subscriber("Zumsr1@bfh.ch","password");
		onlineSubscriberCollection.login(subscriber);
		
		assertTrue(onlineSubscriberCollection.isAlreadyLoggedIn(subscriber));
		onlineSubscriberCollection.logout(subscriber);
		
		assertFalse(onlineSubscriberCollection.isAlreadyLoggedIn(subscriber));
		onlineSubscriberCollection.clear();
	}
}
