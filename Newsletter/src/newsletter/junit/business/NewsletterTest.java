package newsletter.junit.business;

import java.util.Date;
import java.util.Map;

import junit.framework.TestCase;
import newsletter.app.business.*;

/**
 * Test class for the newsletter
 * @author schnl1@bfh.ch
 * @author zumsr1@bfh.ch
 */
public class NewsletterTest extends TestCase{

	
	/**
	 * Tests the subscribe function
	 */
	public void testSubscribe(){
		Subscriber subscriber = new Subscriber("zumsr1@bfh.ch", "myPassword");
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		
		newsletter.subscribe(subscriber);
		assertTrue(newsletter.hasNewsletterSubscription(subscriber));
	}

	/**
	 * Tests the unsubscribe function
	 */
	public void testUnsubscribe(){
		Subscriber subscriber = new Subscriber("zumsr1@bfh.ch", "myPassword");
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		
		newsletter.subscribe(subscriber);
		newsletter.unsubscribe(subscriber);
		assertFalse(newsletter.hasNewsletterSubscription(subscriber));
	}

	/**
	 * Tests the addArticle function
	 */
	public void testAddArticle(){
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		Article article = newsletter.addArticle("NewsletterArticle", "The newsletter project is really funny ;)");
		
		assertTrue("NewsletterArticle".equals(newsletter.getArticle(article.getId()).getTitle()));
	}
	
	/**
	 * Tests the getUnlinkedArticle function
	 */
	public void testGetUnlinkedArticles(){
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		Article article1 = newsletter.addArticle("Article 1", "The newsletter project is really funny ;)");
		Article article2 = newsletter.addArticle("Article 2", "The newsletter project is really funny ;)");
		Article article3 = newsletter.addArticle("Article 3", "The newsletter project is really funny ;)");
		
		Map unlinkedArticles = newsletter.getUnlinkedArticles();
		
		assertTrue(unlinkedArticles.containsValue(article1));
		assertTrue(unlinkedArticles.containsValue(article2));
		assertTrue(unlinkedArticles.containsValue(article3));
		assertTrue(unlinkedArticles.size() == 3);
	}
	
	/**
	 * Tests the compileIssueAndCreateNew function
	 */
	public void testCompileIssueAndCreateNew(){
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		Issue issue = newsletter.compileIssueAndCreateNew(2007, new Date());
		
		assertTrue(issue.getYear() == 2007);
		assertTrue(issue.getId() == 200701);
	}
	
	/**
	 * Tests the setArticleToOpenIssue function
	 */
	public void testLinkArticles(){
		
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		Issue issue = newsletter.compileIssueAndCreateNew(2007, new Date());
		
		Article article1 = newsletter.addArticle("Article 1", "The newsletter project is really funny ;)");
		Article article2 = newsletter.addArticle("Article 2", "The newsletter project is really funny ;)");
		Article article3 = newsletter.addArticle("Article 3", "The newsletter project is really funny ;)");
		
		newsletter.setArticleToOpenIssue(article1.getId());
		newsletter.setArticleToOpenIssue(article2.getId());
		
		Map unlinkedArticles = newsletter.getUnlinkedArticles();
		Map issueArticles = issue.getArticles();
		
		assertFalse(unlinkedArticles.containsValue(article1));
		assertFalse(unlinkedArticles.containsValue(article2));
		assertTrue(unlinkedArticles.containsValue(article3));
		assertTrue(unlinkedArticles.size() == 1);
		
		assertTrue(issueArticles.containsValue(article1));
		assertTrue(issueArticles.containsValue(article2));
		assertFalse(issueArticles.containsValue(article3));
		assertTrue(issueArticles.size() == 2);
	}
	
	/**
	 * Tests the getArticle function
	 */
	public void testGetArticle(){
		Newsletter newsletter = new Newsletter("BFH Newsletter", "blablabla", 6);
		Article article1 = newsletter.addArticle("Article 1", "The newsletter project is really funny ;)");
		
		assertTrue(article1.equals(newsletter.getArticle(article1.getId())));
	}
}
