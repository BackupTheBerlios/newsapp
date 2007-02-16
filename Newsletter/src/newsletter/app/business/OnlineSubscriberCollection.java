package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;


public class OnlineSubscriberCollection {
	private static Map<String, Subscriber> onlineSubscribers = new HashMap<String, Subscriber>();
	private static OnlineSubscriberCollection instance;
	
	private OnlineSubscriberCollection(){}
	
	public static synchronized OnlineSubscriberCollection getInstance(){
		if (instance == null){
			instance = new OnlineSubscriberCollection();
		}	
		return instance;
	}
	
	public void login(Subscriber subscriber){
		if (!isAlreadyLoggedIn(subscriber)){
			onlineSubscribers.get(subscriber);
		}
	}
	
	public void logout(Subscriber subscriber){
		onlineSubscribers.remove(subscriber);
	}
	
	private boolean isAlreadyLoggedIn(Subscriber subscriber){
		return onlineSubscribers.containsValue(subscriber);
	}
}
