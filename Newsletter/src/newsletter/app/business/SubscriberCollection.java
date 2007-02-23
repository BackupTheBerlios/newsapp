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
	
	
	/**
	 * returns all Subscribers
	 * @return Map with all subscribers
	 */
	public Map getAllSubscribers(){
		return subscribers;
	}
	
	public void clear(){
		OnlineSubscriberCollection onlineSubscriberCollection = OnlineSubscriberCollection.getInstance();
		onlineSubscriberCollection.clear();
		subscribers.clear();
	}


	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((subscribers == null) ? 0 : subscribers.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SubscriberCollection other = (SubscriberCollection) obj;
		if (subscribers == null) {
			if (other.subscribers != null)
				return false;
		} else if (!subscribers.equals(other.subscribers))
			return false;
		return true;
	}
	
	
}