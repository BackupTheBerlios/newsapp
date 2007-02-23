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

	/**
	 * test the login function
	 */
	public void testLogin(){
		LoginController loginController = new LoginController();
		RegisterController registerController = new RegisterController();
		
		registerController.register("Zumsr1@bfh.ch", "password");
		registerController.register("Schnl1@bfh.ch", "password");
		
		assertFalse(loginController.login("Zumsr1@bfh.ch", "falsePassword"));
		assertTrue(loginController.login("Zumsr1@bfh.ch", "password"));
		
		OnlineSubscriberCollection onlineSubscriberCollection = OnlineSubscriberCollection.getInstance();
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		
		assertTrue(onlineSubscriberCollection.isAlreadyLoggedIn(subscriberCollection.getSubscriber("Zumsr1@bfh.ch")));
		assertFalse(onlineSubscriberCollection.isAlreadyLoggedIn(subscriberCollection.getSubscriber("Schnl1@bfh.ch")));
		
	}
	
	/**
	 * test the logout function
	 */
	public void testLogout(){
		LoginController loginController = new LoginController();
		RegisterController registerController = new RegisterController();
		
		registerController.register("Zumsr1@bfh.ch", "password");
		registerController.register("Schnl1@bfh.ch", "password");
		
		loginController.login("Schnl1@bfh.ch", "password");
		loginController.login("Zumsr1@bfh.ch", "password");
		
		OnlineSubscriberCollection onlineSubscriberCollection = OnlineSubscriberCollection.getInstance();
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		
		assertTrue(onlineSubscriberCollection.isAlreadyLoggedIn(subscriberCollection.getSubscriber("Zumsr1@bfh.ch")));
		assertTrue(onlineSubscriberCollection.isAlreadyLoggedIn(subscriberCollection.getSubscriber("Schnl1@bfh.ch")));
		
		loginController.logout("Zumsr1@bfh.ch");
		
		assertFalse(onlineSubscriberCollection.isAlreadyLoggedIn(subscriberCollection.getSubscriber("Zumsr1@bfh.ch")));
		assertTrue(onlineSubscriberCollection.isAlreadyLoggedIn(subscriberCollection.getSubscriber("Schnl1@bfh.ch")));
		
		subscriberCollection.clear();
	}
	
	/**
	 * 	test isActive and activate functions
	 */
	public void testIsActive(){
		LoginController loginController = new LoginController();
		RegisterController registerController = new RegisterController();
		
		registerController.register("Zumsr1@bfh.ch", "password");
		registerController.register("Schnl1@bfh.ch", "password");
		
		assertFalse(loginController.isActive("Schnl1@bfh.ch"));
		assertFalse(loginController.isActive("Zumsr1@bfh.ch"));
		
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		
		String activationCode = subscriberCollection.getSubscriber("Schnl1@bfh.ch").getActivationCode();
		loginController.activate("Schnl1@bfh.ch", activationCode);
		
		assertTrue(loginController.isActive("Schnl1@bfh.ch"));
		assertFalse(loginController.isActive("Zumsr1@bfh.ch"));
		
		subscriberCollection.clear();
	}
	
	/**
	 * test the isAdmin function
	 */
	public void testIsAdmin(){
		LoginController loginController = new LoginController();
		RegisterController registerController = new RegisterController();
		
		registerController.register("Zumsr1@bfh.ch", "password");
		registerController.register("Schnl1@bfh.ch", "password");
		
		assertFalse(loginController.isAdmin("Schnl1@bfh.ch"));
		assertFalse(loginController.isAdmin("Zumsr1@bfh.ch"));
		
		SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
		subscriberCollection.getSubscriber("Schnl1@bfh.ch").setAdmin(true);
		
		assertTrue(loginController.isAdmin("Schnl1@bfh.ch"));
		assertFalse(loginController.isAdmin("Zumsr1@bfh.ch"));
	}
}
