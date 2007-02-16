package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;


public class Newsletter {
	private String name;
	private String description;
	private Map<String, Subscriber> subscriberCollection = new HashMap<String, Subscriber>();
		
	public Newsletter(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void subscribe(Subscriber subscriber){
		if (!hasNewsletterSubscription(subscriber)){
			subscriberCollection.put(subscriber.getEMailAddress(), subscriber);
		}
	}
	
	private boolean hasNewsletterSubscription(Subscriber subscriber){
		return subscriberCollection.containsValue(subscriber);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
}
