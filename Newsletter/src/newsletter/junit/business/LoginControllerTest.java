package newsletter.junit.business;

import junit.framework.TestCase;
import newsletter.app.business.*;

/**
 * test class for loginController
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class LoginControllerTest extends TestCase{

	public void testLogin(){
		
		LoginController loginController = new LoginController();
		RegisterController registerController = new RegisterController();
		
		registerController.register("Zumsr1@bfh.ch", "password");
		registerController.register("Schnl1@bfh.ch", "password");
		
		assertTrue(loginController.login("Zumsr1@bfh.ch", "password"));
		
		OnlineSubscriberCollection onlineSubscriberCollection = OnlineSubscriberCollection.getInstance();
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		
		assertTrue(onlineSubscriberCollection.isAlreadyLoggedIn(subscriberCollection.getSubscriber("Zumstr1@bfh.ch")));
	}
}
