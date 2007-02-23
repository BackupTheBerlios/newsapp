package newsletter.app.business;


import java.util.Date;
import java.util.Map;
import java.util.HashMap;

/**
 * Ausgabe eines Newsletters
 * @author lars
 */
public class Issue {

	private int number;
	private Date publishingDate;
	private Boolean isOpen = true;
	private Newsletter newsletter;
	private Map<Integer, Article> articleCollection = new HashMap<Integer, Article>();
	private int year;
	
	/**
	 * constructor of an issue
	 * @param number nummer der ausgabe
	 * @param year erscheinungsjahr
	 * @param publishingDate datum des erscheinungstermins
	 * @param newsletter newsletter
	 */
	public Issue(int number, int year, Date publishingDate, Newsletter newsletter){
		this.number = number;
		this.publishingDate = publishingDate;
		this.newsletter = newsletter;
		this.year = year;
	}
	
	/**
	 * füge einen artikel hinzu
	 * @param article article
	 */
	public void addArticle(Article article){
		this.articleCollection.put(article.getId(), article);
	}
	
	/**
	 * get the id of the article
	 * @return id
	 */
	public int getId(){
		return this.year*100 + this.number;
	}
	
	/**
	 * get the number of the issue
	 * @return number
	 */
	public int getNumber(){
		return this.number;
	}
	
	/**
	 * get the year of publishing
	 * @return year
	 */
	public int getYear(){
		return this.year;
	}
	
	/**
	 * get the date of publishing
	 * @return date
	 */
	public Date getPublishingDate(){
		return this.publishingDate;
	}
	
	/**
	 * get the newsletter containing the issue
	 * @return newsletter
	 */
	public Newsletter getNewsletter(){
		return this.newsletter;
	}
	
	/**
	 * get the articles in the issue
	 * @return articles
	 */
	public Map getArticles(){
		return this.articleCollection;
	}
	/**
	 * get the open status of the issue
	 * @return status
	 */
	public Boolean isOpen(){
		return this.isOpen;
	}
	
	/**
	 * close the issue
	 */
	public void closeIssue(){
		this.isOpen = false;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + number;
		result = PRIME * result + ((publishingDate == null) ? 0 : publishingDate.hashCode());
		result = PRIME * result + year;
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
		final Issue other = (Issue) obj;
		if (number != other.number)
			return false;
		if (publishingDate == null) {
			if (other.publishingDate != null)
				return false;
		} else if (!publishingDate.equals(other.publishingDate))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	
}

