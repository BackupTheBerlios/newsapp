package framework;

import java.util.ArrayList;

public class OnlineSubscriberCollection {
	private static ArrayList<Subscriber> onlineSubscribers;
	
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
