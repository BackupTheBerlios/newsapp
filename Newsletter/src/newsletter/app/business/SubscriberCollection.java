package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;


/**
 * Contains all registred subscribers of the newsletter-system
 * @author Schnl1@bfh.ch
 * @author Zumsr1@bfh.ch
 *
 */
public class SubscriberCollection {
	private Map<String, Subscriber> subscribers = new HashMap<String, Subscriber>();
	private static SubscriberCollection instance;
	
	/**or is private, because it's a singelton.
	 * Construct
	 */
	private SubscriberCollection(){}
	
	
	/**
	 * returns always the same instance of SubscriberCollection
	 * @return SubscriberCollection instance
	 */
	public static synchronized SubscriberCollection getInstance(){
		if (instance == null){
			instance = new SubscriberCollection();
		}
		return instance;
	}
	
	/**
	 * Creates a new Subscriber if it doesn't already exist.
	 * @param eMailAddress
	 * @param password
	 * @return boolean, could the system create the new subscriber?
	 */
	public boolean add(String eMailAddress, String password){
		if (!exists(eMailAddress)){
			subscribers.put(eMailAddress, new Subscriber(eMailAddress, password));
			return true;
		}
		return false;
	}
	
	/**
	 * perform a login, searchs an user with this eMailAddress an d password.
	 * @param eMailAddress
	 * @param password
	 * @return boolean, are eMailAdress and password correct 
	 */
	public boolean login(String eMailAddress, String password){
		return this.getSubscriber(eMailAddress).checkPassword(password);
	}
	
	
	/**
	 * checks if the subscriber with this eMailAddress already exists.
	 * @param eMailAddress
	 * @return boolean, exists a subscriber with this eMailAddress?
	 */
	public boolean exists(String eMailAddress){
		return (getSubscriber(eMailAddress) != null);
	}
	
	
	/**
	 * gets the subscriber-object from eMailAddress. If no such subscriber exists, the system returns null.
	 * @param eMailAddress
	 * @return subscriberObject from eMailAddress
	 */
	public Subscriber getSubscriber(String eMailAddress){
		return subscribers.get(eMailAddress);
	}
	
	public void clear(){
		OnlineSubscriberCollection onlineSubscriberCollection = OnlineSubscriberCollection.getInstance();
		onlineSubscriberCollection.clear();
		subscribers.clear();
	}
}