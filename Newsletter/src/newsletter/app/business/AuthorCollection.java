package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;


/**
 * Contains all registred subscribers of the newsletter-system
 * @author Schnl1@bfh.ch
 * @author Zumsr1@bfh.ch
 *
 */
public class AuthorCollection {
	private Map<String, Author> authors = new HashMap<String, Author>();
	private static AuthorCollection instance;
	
	/**or is private, because it's a singelton.
	 * Construct
	 */
	private AuthorCollection(){}
	
	
	/**
	 * returns always the same instance of AuthorCollection
	 * @return AuthorCollection instance
	 */
	public static synchronized AuthorCollection getInstance(){
		if (instance == null){
			instance = new AuthorCollection();
		}
		return instance;
	}
	
	/**
	 * Creates a new Author if it doesn't already exist.
	 * @param eMailAddress
	 * @param password
	 * @return boolean, could the system create the new subscriber?
	 */
	public boolean add(String eMailAddress, String name, String firstName){
		if (!exists(eMailAddress)){
			authors.put(eMailAddress, new Author(eMailAddress, name, firstName));
			return true;
		}
		return false;
	}
	
	
	/**
	 * checks if the author with this eMailAddress already exists.
	 * @param eMailAddress
	 * @return boolean, exists an author with this eMailAddress?
	 */
	public boolean exists(String eMailAddress){
		return (getAuthor(eMailAddress) != null);
	}
	
	
	/**
	 * gets the author-object from eMailAddress. If no such author exists, the system returns null.
	 * @param eMailAddress
	 * @return authorObject from eMailAddress
	 */
	public Author getAuthor(String eMailAddress){
		return authors.get(eMailAddress);
	}
	

	/**
	 * returns all authors
	 * @return Map of all authors
	 */
	public Map getAllAuthors(){
		return authors;
	}
	
	/**
	 * clear the authorCollection
	 */
	public void clear(){
		authors.clear();
	}
}