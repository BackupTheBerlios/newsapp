package newsletter.junit.business;

import java.util.Map;

import junit.framework.TestCase;
import newsletter.app.business.*;


/**
 * Test class for the newsletterCollection
 * @author schnl1@bfh.ch
 * @author zumsr1@bfh.ch
 */
public class NewsletterCollectionTest extends TestCase{

	
	/**
	 * Tests the add, exists function
	 */
	public void testExists(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		
		newsletterCollection.add("BFH Newsletter", "blablabla", 6);
		
		assertTrue(newsletterCollection.exists("BFH Newsletter"));
	}
	
	/**
	 * Tests the getNewsletter function
	 */
	public void testGetNewsletter(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		
		newsletterCollection.add("BFH Newsletter", "blablabla", 6);
		
		assertTrue("BFH Newsletter".equals(newsletterCollection.getNewsletter("BFH Newsletter").getName()));
	}
	
	/**
	 * Tests the getAllNewsletters function
	 */
	public void testGetAllNewsletters(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		
		String newsletter1 = newsletterCollection.add("newsletter1", "blablabla", 3);
		String newsletter2 = newsletterCollection.add("newsletter2", "blablabla", 6);
		String newsletter3 = newsletterCollection.add("newsletter3", "blablabla", 12);

		Map newsletters = newsletterCollection.getAllNewsletters();
		
		assertTrue(newsletters.containsKey(newsletter1));
		assertTrue(newsletters.containsKey(newsletter2));
		assertTrue(newsletters.containsKey(newsletter3));
	}
	
	/**
	 * Tests the Singelton function
	 */
	public void testSingleton(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		
		assertTrue(newsletterCollection.getAllNewsletters().size() > 0);
	}
}
