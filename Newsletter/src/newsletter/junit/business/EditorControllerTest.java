package newsletter.junit.business;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import newsletter.app.business.*;
import junit.framework.TestCase;

/**
 * test class for EditorController
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class EditorControllerTest extends TestCase{

	/**
	 * test newArticle and getAllUnlinkedArticles functions
	 */
	public void testNewArticle(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		String newsletterName1 = newsletterCollection.add("Newsletter1", "BFH Newsletter", 6);
		EditorController controller = new EditorController();
		int articleId = controller.newArticle("Article1", "blablabla", newsletterName1);			
		Set articleIds = controller.getAllUnlinkedArticles(newsletterName1);
	
		assertTrue(articleIds.contains(articleId));
		newsletterCollection.clear();
	}
	
	/**
	 * test setAuthorToArticle functions
	 */
	public void testSetAuthorToArticle(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		AuthorCollection authorCollection = AuthorCollection.getInstance();
		
		String newsletterName = newsletterCollection.add("Newsletter1", "BFH Newsletter", 6); 
		authorCollection.add("Zumsr1@bfh.ch", "Zumstein", "Ramon");
		
		EditorController controller = new EditorController();
		
		int articleId = controller.newArticle("Article1", "blablabla", newsletterName);
		controller.setAuthorToArticle(newsletterName, articleId, "Zumsr1@bfh.ch");
		Map authors = newsletterCollection.getNewsletter(newsletterName).getArticle(articleId).getAuthors();
		
		assertTrue(authors.containsKey("Zumsr1@bfh.ch"));
		newsletterCollection.clear();
	}
	
	/**
	 * test setArticleToOpenIssue functions
	 */
	public void testSetArticleToOpenIssue(){
		NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
		
		String newsletterName = newsletterCollection.add("Newsletter1", "BFH Newsletter", 6); 
	
		Article article1 = newsletterCollection.getNewsletter(newsletterName).addArticle("Article1", "blablabla");
		Article article2 = newsletterCollection.getNewsletter(newsletterName).addArticle("Article2", "blablabla");
		Article article3 = newsletterCollection.getNewsletter(newsletterName).addArticle("Article3", "blablabla");
		
		EditorController controller = new EditorController();
		
		assertTrue(newsletterCollection.getNewsletter(newsletterName).getUnlinkedArticles().size() == 3);
		
		controller.compileIssueAndCreateNew(newsletterName, 2007, new Date());
		
		controller.setArticleToOpenIssue(newsletterName, article1.getId());
		controller.setArticleToOpenIssue(newsletterName, article2.getId());
		controller.setArticleToOpenIssue(newsletterName, article3.getId());
		
		assertTrue(newsletterCollection.getNewsletter(newsletterName).getUnlinkedArticles().size() == 0);
	}
}
