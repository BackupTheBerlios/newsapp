package newsletter.app.business;


/**
 * the RegisterController handles the interactions between GUI and Systemobjects
 * for registration of a new subscriber
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class RegisterController {
	private SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();

	/**
	 * register a new subscriber for the newsletterSystem. If there is already a subscriber with
	 * this eMailAddress, the system returns false.
	 * @param eMailAddress
	 * @param password
	 * @return boolean, could the system register this eMailAddress?
	 */
	public boolean register(String eMailAddress, String password){
		return subscriberCollection.add(eMailAddress, password);
	}
}
