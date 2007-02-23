package newsletter.app.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * the EditorController handles the interactions between GUI and Systemobjects
 * for
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
	
	/**
	 * @param newsletterName
	 * @return
	 */
	public List getAllUnlinkedArticles(String newsletterName){
		List arrReturn = new ArrayList();
		return arrReturn;
	}
	
	/**
	 * @param title
	 * @param text
	 * @param newsletterName
	 * @return
	 */
	public int newArticle(String title, String text, String newsletterName){
		Article article = new Article(title, text);
		newsletterCollection.getNewsletter(newsletterName).addArticle(article);
		return article.getId();
	}
	
	/**
	 * @param newsletterName
	 * @param articleId
	 * @param authorId
	 */
	public void setAuthorToArticle(String newsletterName, String articleId, String authorId){
		
	}
	
	/**
	 * @param newsletterName
	 * @param articleId
	 */
	public void setArticleToOpenIssue(String newsletterName, int articleId){
		newsletterCollection.getNewsletter(newsletterName).setArticleToOpenIssue(articleId);
	}
	
	/**
	 * @param newsletterName
	 * @param year
	 * @param publishingDate
	 * @return
	 */
	public int compileIssueAndCreateNew(String newsletterName, int year, Date publishingDate){
		return newsletterCollection.getNewsletter(newsletterName).compileIssueAndCreateNew(year, publishingDate).getId();
	}
}
