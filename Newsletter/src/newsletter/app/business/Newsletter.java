package newsletter.app.business;

import java.util.ArrayList;


public class Newsletter {
	private String name;
	private String description;
	private ArrayList<Subscriber> subscriberCollection = new ArrayList<Subscriber>();
		
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
			subscriberCollection.add(subscriber);
		}
	}
	
	private boolean hasNewsletterSubscription(Subscriber subscriber){
		return subscriberCollection.contains(subscriber);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
}
