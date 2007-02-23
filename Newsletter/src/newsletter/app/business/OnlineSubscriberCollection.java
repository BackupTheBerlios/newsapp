package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 * @version 1.0
 * 
 * OnlineSubscriberCollection enthält alle Subscriber, die zur Zeit online sind.
 */
public class OnlineSubscriberCollection {
	private static Map<String, Subscriber> onlineSubscribers = new HashMap<String, Subscriber>();
	private static OnlineSubscriberCollection instance;
	
	
	/**
	 * Constructor ist privat, weil es ein Singelton ist.
	 */
	private OnlineSubscriberCollection(){}
	
	
	/**
	 * Gibt immer die gleiche Instanz von OnlineSubscriberCollection zurück
	 * @return OnlineSubscriberCollection
	 */
	public static synchronized OnlineSubscriberCollection getInstance(){
		if (instance == null){
			instance = new OnlineSubscriberCollection();
		}	
		return instance;
	}
	
	/**
	 * Perform a login. Adds subscriber to onlineSubscriberCollection
	 * @param subscriber
	 */
	public void login(Subscriber subscriber){
		if (!isAlreadyLoggedIn(subscriber)){
			onlineSubscribers.put(subscriber.getEMailAddress(), subscriber);
		}
	}
	
	/**
	 * Perform logout. Remove Subscriber from onlineSubscriberCollection
	 * @param subscriber
	 */
	public void logout(Subscriber subscriber){
		onlineSubscribers.remove(subscriber);
	}
	
	
	/**
	 * Checks, if an user is already logged in or not.
	 * @param subscriber
	 * @return Boolean, is the user already logged in?
	 */
	public boolean isAlreadyLoggedIn(Subscriber subscriber){
		return onlineSubscribers.containsValue(subscriber);
	}
}
