package newsletter.app.business;

import java.util.Date;
import java.util.Set;


/**
 * the EditorController handles the interactions between GUI and Systemobjects
 * for manage and compile issues.
 * 
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class EditorController {
	/**
	 * Constructor
	 */
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	private AuthorCollection authorCollection = AuthorCollection.getInstance();
	
	/**
	 * returns all unlinked articles of a newsletter
	 * @param newsletterName
	 * @return Set of all unlinked articles of the newsletter
	 */
	public Set getAllUnlinkedArticles(String newsletterName){
		return newsletterCollection.getNewsletter(newsletterName).getUnlinkedArticles().keySet();
	}
	
	/**
	 * creates a new article for a newsletter
	 * @param title
	 * @param text
	 * @param newsletterName
	 * @return articleId of the created article
	 */
	public int newArticle(String title, String text, String newsletterName){
		return newsletterCollection.getNewsletter(newsletterName).addArticle(title, text);
	}
	
	/**
	 * adds an author to an article
	 * @param newsletterName
	 * @param articleId
	 * @param authorId
	 */
	public void setAuthorToArticle(String newsletterName, int articleId, String authorMailAddress){
		Author author = authorCollection.getAuthor(authorMailAddress);
		newsletterCollection.getNewsletter(newsletterName).getArticle(articleId).addAuthor(author);
	}
	
	/**
	 * link an article with openIssue
	 * @param newsletterName
	 * @param articleId
	 */
	public void setArticleToOpenIssue(String newsletterName, int articleId){
		newsletterCollection.getNewsletter(newsletterName).setArticleToOpenIssue(articleId);
	}
	
	/**
	 * Compile the open issue and create a new open Issue
	 * @param newsletterName
	 * @param year
	 * @param publishingDate
	 * @return 
	 */
	public int compileIssueAndCreateNew(String newsletterName, int year, Date publishingDate){
		return newsletterCollection.getNewsletter(newsletterName).compileIssueAndCreateNew(year, publishingDate).getId();
	}
}
