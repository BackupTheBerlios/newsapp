package newsletter.app.business;

import java.util.ArrayList;

public class OnlineSubscriberCollection {
	private static ArrayList<Subscriber> onlineSubscribers = new ArrayList<Subscriber>();
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
			onlineSubscribers.add(subscriber);
		}
	}
	
	public void logout(Subscriber subscriber){
		onlineSubscribers.remove(subscriber);
	}
	
	private boolean isAlreadyLoggedIn(Subscriber subscriber){
		return onlineSubscribers.contains(subscriber);
	}
}
