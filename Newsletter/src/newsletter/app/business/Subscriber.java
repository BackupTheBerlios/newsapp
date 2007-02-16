package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;



public class Subscriber {
	private String activationCode;
	private String eMailAddress;
	private String password;
	private boolean isSubscriberActive;
	private boolean isSubscriberAdmin;
	private Map<String, Newsletter> newsletterCollection = new HashMap<String, Newsletter>();

	public Subscriber(String eMailAddress, String password){
		this.eMailAddress = eMailAddress;
		this.password = password;
	}
	
	public void subscribe(Newsletter newsletter){
		if (!hasNewsletterSubscription(newsletter)){
			newsletterCollection.put(newsletter.getName(), newsletter);
		}
	}
	
	public void unsubscribe(Newsletter newsletter){
		if (hasNewsletterSubscription(newsletter)){
			newsletterCollection.remove(newsletter);
		}
	}
	
	public Map<String, Newsletter> getSubscription(){
		return newsletterCollection;
	}
	
	public boolean activate(String activationCode){
		if (this.activationCode == activationCode){
			this.isSubscriberActive = true;
		}
		return isSubscriberActive;
	}
	
	public boolean checkPassword(String password){
		return this.password.equals(password);
	}
	
	
	private boolean hasNewsletterSubscription(Newsletter newsletter){
		return newsletterCollection.containsValue(newsletter);
	}
	
	/* GETTER METHODS*/
	public boolean isActive(){
		return isSubscriberActive;
	}
	
	public boolean isAdmin(){
		return isSubscriberAdmin;
	}
	
	public String getActivationCode(){
		return activationCode;
	}
	
	public String getEMailAddress(){
		return eMailAddress;
	}
}