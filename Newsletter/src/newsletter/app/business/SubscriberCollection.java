package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;



public class SubscriberCollection {
	private Map<String, Subscriber> subscribers = new HashMap<String, Subscriber>();
	private static SubscriberCollection instance;
	
	private SubscriberCollection(){}
	
	public static synchronized SubscriberCollection getInstance(){
		if (instance == null){
			instance = new SubscriberCollection();
		}
		return instance;
	}
	
	public boolean add(String eMailAddress, String password){
		if (!exists(eMailAddress)){
			subscribers.put(eMailAddress, new Subscriber(eMailAddress, password));
			return true;
		}
		return false;
	}
	
	public Subscriber login(String eMailAddress, String password){
		return null;
	}
	
	public boolean exists(String eMailAddress){
		return (getSubscriber(eMailAddress) != null);
	}
	
	public Subscriber getSubscriber(String eMailAddress){
		return subscribers.get(eMailAddress);
	}
}
