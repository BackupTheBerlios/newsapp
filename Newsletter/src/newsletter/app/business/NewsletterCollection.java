package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;


/**
 * The newsletterCollection contains every newsletter of the newsletter system.
 * @author Schnl1@bfh.ch
 * @author Zumsr1@bfh.ch
 *
 */
public class NewsletterCollection {
	private Map<String, Newsletter> newsletters = new HashMap<String, Newsletter>();
	private static NewsletterCollection instance;
	
	/**
	 * Constructor is private because it's singelton
	 */
	private NewsletterCollection(){}
	
	
	/**
	 * gets an instance of NewsletterCollection
	 * @return NewsletterCollection instance
	 */
	public static synchronized NewsletterCollection getInstance(){
		if (instance == null){
			instance = new NewsletterCollection();
		}
		return instance;
	}
	
	/**
	 * adds a new newsletter to the sytem
	 * @param name
	 * @param description
	 * @param periodicity
	 * @return the name of the new created newsletter, if the newsletter already exists, return null
	 */
	public String add(String name, String description, int periodicity){
		if (!exists(name)){
			newsletters.put(name, new Newsletter(name, description, periodicity));
			return name;
		}
		return null;
	}
	
	/**
	 * checks if a newsletter already exists
	 * @param name
	 * @return boolean, exists already a newsletter with this name
	 */
	public boolean exists(String name){
		return (getNewsletter(name) != null);
	}
	
	/**
	 * gets a newsletter from name
	 * @param name
	 * @return the newsletter
	 */
	public Newsletter getNewsletter(String name){
		return newsletters.get(name);
	}
	
	public Map getAllNewsletters(){
		return this.newsletters;
	}
	
	public void clear(){
		newsletters.clear();
	}


	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((newsletters == null) ? 0 : newsletters.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final NewsletterCollection other = (NewsletterCollection) obj;
		if (newsletters == null) {
			if (other.newsletters != null)
				return false;
		} else if (!newsletters.equals(other.newsletters))
			return false;
		return true;
	}
	
	
}