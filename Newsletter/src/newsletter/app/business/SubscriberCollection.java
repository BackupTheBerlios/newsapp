package newsletter.app.business;

import java.util.ArrayList;


public final class SubscriberCollection {
	private static ArrayList<Subscriber> subscribers;
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
			subscribers.add(new Subscriber(eMailAddress, password));
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
		return null;
	}
}
