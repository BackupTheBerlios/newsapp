package newsletter.junit.business;

import java.util.Set;

import newsletter.app.business.*;
import junit.framework.TestCase;

/**
 * test class for NewsletterController
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class NewsletterControllerTest extends TestCase{

	/**
	 * test the newNewsletter and getAllNewsletters function
	 */
	public void testNewNewsletter(){
		NewsletterController newsletterController = new NewsletterController();
		
		newsletterController.newNewsletter("BFH Newsletter", "blablabla", 6);
		Set newsletters = newsletterController.getAllNewsletters();
		
		assertTrue(newsletters.contains("BFH Newsletter"));
	}
	
	
	/**
	 * tests the getter and setter methods 
	 */
	public void testSetterMethods(){
		NewsletterController newsletterController = new NewsletterController();

		newsletterController.newNewsletter("Newsletter1", "blablabla", 6);
		newsletterController.setDescription("Newsletter1", "NewDescription");
		newsletterController.setPeriodicity("Newsletter1", 3);
		
		assertTrue("NewDescription".equals(newsletterController.getDescription("Newsletter1")));
		assertTrue(newsletterController.getPeriodicity("Newsletter1") == 3);
		
	}
	
	
}