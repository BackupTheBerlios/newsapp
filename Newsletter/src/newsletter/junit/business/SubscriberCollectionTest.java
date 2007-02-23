package newsletter.junit.business;

import java.util.Map;

import junit.framework.TestCase;
import newsletter.app.business.*;


/**
 * Test class for the subscriberCollection
 * @author schnl1@bfh.ch
 * @author zumsr1@bfh.ch
 */
public class SubscriberCollectionTest extends TestCase{

	
	/**
	 * Tests the add, exists function
	 */
	public void testExists(){
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		
		subscriberCollection.add("Zumsr1@bfh.ch", "password");
		assertTrue(subscriberCollection.exists("Zumsr1@bfh.ch"));
		subscriberCollection.clear();
	}
	
	/**
	 * Tests the getsubscriber function
	 */
	public void testGetSubscriber(){
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		subscriberCollection.add("Zumsr1@bfh.ch", "password");
		
		assertTrue("Zumsr1@bfh.ch".equals(subscriberCollection.getSubscriber("Zumsr1@bfh.ch").getEMailAddress()));
		subscriberCollection.clear();
	}
	
	/**
	 * Tests the getAllsubscribers function
	 */
	public void testGetAllsubscribers(){
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		
		subscriberCollection.add("Zumsr1@bfh.ch", "password");
		subscriberCollection.add("Schnl1@bfh.ch", "password");
		
		Map subscribers = subscriberCollection.getAllSubscribers();
		
		assertTrue(subscribers.containsKey("Zumsr1@bfh.ch"));
		assertTrue(subscribers.containsKey("Schnl1@bfh.ch"));
	}
	
	/**
	 * Tests the Singelton function
	 */
	public void testSingleton(){
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		
		assertTrue(subscriberCollection.getAllSubscribers().size() > 0);
		subscriberCollection.clear();
	}
}
