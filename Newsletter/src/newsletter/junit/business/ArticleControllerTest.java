package newsletter.junit.business;

import newsletter.app.business.*;
import junit.framework.TestCase;

/**
 * test class for ArticleController
 * @author Ramon
 *
 */
public class ArticleControllerTest extends TestCase{
	/**
	 * test the getArticleTitle function
	 */
	public void testGetArticleTitle(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		
		String newsletter1 = newsletterCollection.add("Newsletter1", "blablabla", 6);		
		Article article = newsletterCollection.getNewsletter(newsletter1).addArticle("Article1", "blablabla");
		
		ArticleController controller = new ArticleController();
		assertTrue("Article1".equals(controller.getArticleTitle(newsletter1, article.getId())));
		newsletterCollection.clear();
	}
	
	/**
	 * test the getArticleText function
	 */
	public void testGetArticleText(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		
		String newsletter1 = newsletterCollection.add("Newsletter1", "blablabla", 6);		
		Article article = newsletterCollection.getNewsletter(newsletter1).addArticle("Article1", "blablabla");
		
		ArticleController controller = new ArticleController();
		assertTrue("blablabla".equals(controller.getArticleText(newsletter1, article.getId())));
	}
}
