package framework;

import java.util.ArrayList;


public class Subscriber {
	private String activationCode;
	private String eMailAddress;
	private String password;
	private boolean isSubscriberActive;
	private boolean isSubscriberAdmin;
	private ArrayList<Newsletter> newsletterCollection;

	public Subscriber(String eMailAddress, String password){
		this.eMailAddress = eMailAddress;
		this.password = password;
	}
	
	public void subscribe(Newsletter newsletter){
		if (!hasNewsletterSubscription(newsletter)){
			newsletterCollection.add(newsletter);
		}
	}
	
	public void unsubscribe(Newsletter newsletter){
		newsletterCollection.remove(newsletter);
	}
	
	public ArrayList<Newsletter> getSubscription(){
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
		return newsletterCollection.contains(newsletter);
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
