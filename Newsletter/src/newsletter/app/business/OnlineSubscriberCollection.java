package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;

/**
 * OnlineSubscriberCollection contains all online Subscribers
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 * @version 1.0
 * 
 * OnlineSubscriberCollection enth�lt alle Subscriber, die zur Zeit online sind.
 */
public class OnlineSubscriberCollection {
	private  Map<String, Subscriber> onlineSubscribers = new HashMap<String, Subscriber>();
	private static OnlineSubscriberCollection instance;
	
	
	/**
	 * Constructor ist privat, weil es ein Singelton ist.
	 */
	private OnlineSubscriberCollection(){}
	
	
	/**
	 * Gibt immer die gleiche Instanz von OnlineSubscriberCollection zur�ck
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
		onlineSubscribers.remove(subscriber.getEMailAddress());
	}
	
	
	/**
	 * Checks, if an user is already logged in or not.
	 * @param subscriber
	 * @return Boolean, is the user already logged in?
	 */
	public boolean isAlreadyLoggedIn(Subscriber subscriber){
		return onlineSubscribers.containsValue(subscriber);
	}
	
	/**
	 * Clear OnlineSubscribers
	 */
	public void clear(){
		onlineSubscribers.clear();
	}


	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((onlineSubscribers == null) ? 0 : onlineSubscribers.hashCode());
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
		final OnlineSubscriberCollection other = (OnlineSubscriberCollection) obj;
		if (onlineSubscribers == null) {
			if (other.onlineSubscribers != null)
				return false;
		} else if (!onlineSubscribers.equals(other.onlineSubscribers))
			return false;
		return true;
	}
	
	
}
