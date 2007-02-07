package framework;

/**
 * @author zumsr1@bfh.ch
 * @author schnl1@bfh.ch
 *
 */
public class LoginController {
	private SubscriberCollection subscriberCollection;
	private OnlineSubscriberCollection onlineSubscriberCollection;
	
	
	/**
	 * @param eMailAddress 
	 * @param password
	 * @return
	 */
	public boolean login(String eMailAddress, String password){
		Subscriber actSubscriber = subscriberCollection.login(eMailAddress, password);
		if (actSubscriber != null){
			onlineSubscriberCollection.login(actSubscriber);
			return true;
		}
		return false;	
	}
	
	/**
	 * @param eMailAddress
	 * @return SubscriberCollection
	 */
	public boolean isActive(String eMailAddress){
		return subscriberCollection.getSubscriber(eMailAddress).isActive();
	}
	
	/**
	 * @param eMailAddress
	 * @param activationCode
	 * @return
	 */
	public boolean activate(String eMailAddress, String activationCode){
		return subscriberCollection.getSubscriber(eMailAddress).activate(activationCode);
	}

}
