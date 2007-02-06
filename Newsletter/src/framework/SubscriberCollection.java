package framework;

import java.util.ArrayList;


public class SubscriberCollection {
	private static ArrayList<Subscriber> subscribers;
	
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
