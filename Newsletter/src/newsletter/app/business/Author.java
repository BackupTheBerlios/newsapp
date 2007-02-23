package newsletter.app.business;

import java.util.HashMap;
import java.util.Map;

/**
 * The Author of an Article
 * @author schnl1, zumsr1
 */
public class Author {
	private String name;
	private String firstName;
	private int id;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	
	/**
	 * constructor
	 * @param id id of the author
	 * @param name name of the author
	 * @param firstName firstname of the author
	 */
	public Author(int id, String name, String firstName){
		this.name = name;
		this.firstName = firstName;
		this.id = id;
	}
	
	/**
	 * get the id of the author
	 * @return id
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * get the name of the author
	 * @return name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * return the firstname of the author
	 * @return firstname
	 */
	public String getFirstName(){
		return this.firstName;
	}
	
	/**
	 * get the articles written by the author
	 * @return articles
	 */
	public Map getArticles(){
		return articleCollection;
	}


	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = PRIME * result + id;
		result = PRIME * result + ((name == null) ? 0 : name.hashCode());
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
		final Author other = (Author) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	


}
