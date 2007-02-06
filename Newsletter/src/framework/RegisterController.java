package framework;


public class RegisterController {
	private SubscriberCollection subscriberCollection;

	public boolean register(String eMailAddress, String password){
		return subscriberCollection.add(eMailAddress, password);
	}
}
