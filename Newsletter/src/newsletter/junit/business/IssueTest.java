package newsletter.junit.business;

import java.util.Date;
import java.util.Map;

import newsletter.app.business.*;
import junit.framework.TestCase;


/**
 * test class for Issue
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class IssueTest extends TestCase {
	
	/**
	 * test addArticle and getArticles function
	 */
	public void testAddArticle(){
		Newsletter newsletter = new Newsletter("Newsletter1", "blablabla", 3);
		Issue issue = new Issue(1, 2007, new Date(), newsletter);
		
		issue.addArticle(new Article(1, "Article1", "Text1"));
		issue.addArticle(new Article(2, "Article2", "Text2"));
		issue.addArticle(new Article(3, "Article3", "Text3"));
		
		Map articles = issue.getArticles();
		
		assertTrue(articles.containsKey(1));
		assertTrue(articles.containsKey(2));
		assertTrue(articles.containsKey(3));
		assertFalse(articles.containsKey(4));
	}
}
