package newsletter.junit.business;

import newsletter.app.business.*;
import junit.framework.TestCase;

/**
 * test class for RegisterController
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class RegisterControllerTest extends TestCase{

	
	/**
	 * test the register function
	 */
	public void testRegister(){
		RegisterController registerController = new RegisterController();
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		registerController.register("Zumsr1@bfh.ch", "password");
		
		assertTrue(subscriberCollection.exists("Zumsr1@bfh.ch"));
		subscriberCollection.clear();
	}
}
