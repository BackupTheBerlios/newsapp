package newsletter.app.business;

/**
 * @author zumsr1@bfh.ch
 * @author schnl1@bfh.ch
 *
 */
public final class LoginController {
	private SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();
	private OnlineSubscriberCollection onlineSubscriberCollection = OnlineSubscriberCollection.getInstance();
	
	
	/**
	 * perform login. checks, if the password match and adds the subscriber to the onlineSubscriberCollection
	 * @param eMailAddress 
	 * @param password
	 * @return boolean, is the user now logged in?
	 */
	public boolean login(String eMailAddress, String password){
		if (subscriberCollection.login(eMailAddress, password)){
			onlineSubscriberCollection.login(subscriberCollection.getSubscriber(eMailAddress));
			return true;
		}
		return false;	
	}
	
	
	/**
	 * perform logout
	 * @param eMailAddress
	 */
	public void logout(String eMailAddress){
		onlineSubscriberCollection.logout(subscriberCollection.getSubscriber(eMailAddress));
	}
	
	
	/**
	 * is the subscriber active 
	 * @param eMailAddress
	 * @return SubscriberCollection
	 */
	public boolean isActive(String eMailAddress){
		return subscriberCollection.getSubscriber(eMailAddress).isActive();
	}
	
	/**
	 * activate an user, if the activationCode match
	 * @param eMailAddress
	 * @param activationCode
	 * @return boolean, is the user now active?
	 */
	public boolean activate(String eMailAddress, String activationCode){
		return subscriberCollection.getSubscriber(eMailAddress).activate(activationCode);
	}
	
	
	/**
	 * is the user an etitor
	 * @param eMailAddress
	 * @return boolen, is the user an editor?
	 */
	public boolean isAdmin(String eMailAddress){
		return subscriberCollection.getSubscriber(eMailAddress).isAdmin();
	}

}
