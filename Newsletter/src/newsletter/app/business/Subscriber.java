package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;



/**
 * A subscriber can subscribe to the newsletters. A subscriber can also be an editor
 * @author Schnl1@bfh.ch
 * @author Zumsr1@bfh.ch
 * @version 1.0
 *
 */
public class Subscriber {
	private String activationCode;
	private String eMailAddress;
	private String password;
	private boolean isSubscriberActive;
	private boolean isSubscriberAdmin;
	private Map<String, Newsletter> newsletterCollection = new HashMap<String, Newsletter>();

	/**
	 * A subscriber is defined by his eMailAddress
	 * @param eMailAddress
	 * @param password
	 */
	public Subscriber(String eMailAddress, String password){
		RandomString rs = new RandomString(System.currentTimeMillis());
		this.eMailAddress = eMailAddress;
		this.password = password;
		this.activationCode = rs.nextString(6);
	}
	
	/**
	 * adds a newsletter to his subscriptionlist.
	 * @param newsletter
	 */
	public void subscribe(Newsletter newsletter){
		if (!hasNewsletterSubscription(newsletter)){
			newsletterCollection.put(newsletter.getName(), newsletter);
		}
	}
	
	/**
	 * unsubscribe from newsletter
	 * @param newsletter
	 */
	public void unsubscribe(Newsletter newsletter){
		if (hasNewsletterSubscription(newsletter)){
			newsletterCollection.remove(newsletter.getName());
		}
	}
	
	
	/**
	 * gets the List of newsletter-subscriptions
	 * @return Map of all newsletter, which the subscriber is subscribed to.
	 */
	public Map<String, Newsletter> getSubscription(){
		return newsletterCollection;
	}
	
	
	/**
	 * activates an subscriber-account
	 * @param activationCode
	 * @return boolean, is the account now active?
	 */
	public boolean activate(String activationCode){
		if (this.activationCode == activationCode){
			this.isSubscriberActive = true;
		}
		return isSubscriberActive;
	}
	
	/**
	 * checks the password
	 * @param password
	 * @return boolean, is it the same password?
	 */
	public boolean checkPassword(String password){
		return this.password.equals(password);
	}
	
	
	/**
	 * checks, if the subscriber is subscribed to an defined newsletter
	 * @param newsletter
	 * @return boolean, exists a subscription for this newsletter?
	 */
	public boolean hasNewsletterSubscription(Newsletter newsletter){
		return newsletterCollection.containsValue(newsletter);
	}
	
	 /**
	 * checks if the account is active or not
	 * @return boolean, is the account active?
	 */
	public boolean isActive(){
		return isSubscriberActive;
	}
	
	/**
	 * checks if the account is an editor-account
	 * @return boolean, is the subscriber an editor?
	 */
	public boolean isAdmin(){
		return isSubscriberAdmin;
	}
	
	/**
	 * returns the generated activationCode
	 * @return the activationCode
	 */
	public String getActivationCode(){
		return activationCode;
	}
	
	/**
	 * returns the eMailAddress of the subscriber
	 * @return eMailAddress
	 */
	public String getEMailAddress(){
		return eMailAddress;
	}
	
	
	/**
	 * changes admin state of the subscriber
	 * @param isAdmin
	 */
	public void setAdmin(Boolean isAdmin){
		this.isSubscriberAdmin = isAdmin;
	}
}