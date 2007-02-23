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
	private String emailaddress;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	
	/**
	 * constructor
	 * @param emailaddress emailaddress of the author
	 * @param name name of the author
	 * @param firstName firstname of the author
	 */
	public Author(String emailaddress, String name, String firstName){
		this.name = name;
		this.firstName = firstName;
		this.emailaddress = emailaddress;
	}
	
	/**
	 * get the id of the author
	 * @return id
	 */
	public String getEMailAddress(){
		return this.emailaddress;
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

	/**
	 * add an article to authors articleCollection
	 * @param article
	 */
	public void addArticle(Article article){
		articleCollection.put(article.getId(), article);
	}
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((emailaddress == null) ? 0 : emailaddress.hashCode());
		result = PRIME * result + ((firstName == null) ? 0 : firstName.hashCode());
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
		if (emailaddress == null) {
			if (other.emailaddress != null)
				return false;
		} else if (!emailaddress.equals(other.emailaddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	

}
