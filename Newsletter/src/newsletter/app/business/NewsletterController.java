package newsletter.app.business;

import java.util.Set;

/**
 * the NewsletterController handles the interactions between GUI and Systemobjects
 * for every newsletter modifications
 * @author Ramon
 *
 */
public class NewsletterController {
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	
	/**
	 * creates a new newsletter
	 * @param name name of the newsletter
	 * @param description
	 * @param periodicity
	 * @return the name of the new created newsletter
	 */
	public String newNewsletter(String name, String description, int periodicity){
		return newsletterCollection.add(name, description, periodicity);
	}
	
	/**
	 * returns a list with the name of every newsletter
	 * @return List with the name of every newsletter
	 */
	public Set getAllNewsletters(){
		return newsletterCollection.getAllNewsletters().keySet();
	}
	
	/**
	 * returns the description of a newsletter 
	 * @param newsletterName
	 * @return description of the newsletter
	 */
	public String getDescription(String newsletterName){
		return newsletterCollection.getNewsletter(newsletterName).getDescription();
	}
	
	/**
	 * returns the periodicity of a newsletter
	 * @param newsletterName
	 * @return periodicity of the newsletter
	 */
	public int getPeriodicity(String newsletterName){
		return newsletterCollection.getNewsletter(newsletterName).getPeriodicity();
	}
	
	/**
	 * changes the decription of a newsletter
	 * @param newsletterName
	 * @param description
	 */
	public void setDescription(String newsletterName, String description){
		newsletterCollection.getNewsletter(newsletterName).setDescription(description);
	}
	
	/**
	 * changes the periodicity of the newsletter
	 * @param newsletterName
	 * @param periodicity (how many issues per year)
	 */
	public void setPeriodicity(String newsletterName, int periodicity){
		newsletterCollection.getNewsletter(newsletterName).setPeriodicity(periodicity);
	}
}
