package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;


public class NewsletterCollection {
	private Map<String, Newsletter> newsletters = new HashMap<String, Newsletter>();
	private static NewsletterCollection instance;
	
	private NewsletterCollection(){}
	
	public static synchronized NewsletterCollection getInstance(){
		if (instance == null){
			instance = new NewsletterCollection();
		}
		return instance;
	}
	
	public boolean add(String name, String description){
		if (!exists(name)){
			newsletters.put(name, new Newsletter(name, description));
			return true;
		}
		return false;
	}
	
	public boolean exists(String name){
		return (getNewsletter(name) != null);
	}
	
	public Newsletter getNewsletter(String name){
		return newsletters.get(name);
	}
}