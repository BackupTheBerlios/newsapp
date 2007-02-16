package newsletter.app.business;


public class RegisterController {
	private SubscriberCollection subscriberCollection = SubscriberCollection.getInstance();

	public boolean register(String eMailAddress, String password){
		return subscriberCollection.add(eMailAddress, password);
	}
}
