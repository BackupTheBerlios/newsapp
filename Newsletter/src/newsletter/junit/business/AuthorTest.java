package newsletter.junit.business;

import java.util.Map;

import newsletter.app.business.Article;
import newsletter.app.business.Author;
import junit.framework.TestCase;

/**
 * test class for Author
 * @author Zumsr1@bfh.ch
 * @author Schnl1@bfh.ch
 *
 */
public class AuthorTest extends TestCase{

	/**
	 * test the addArticle and getArticles function
	 */
	public void testGetArticles(){
		Author author = new Author("zumsr1@bfh.ch", "Zumstein", "Ramon");
		author.addArticle(new Article(1, "Article1", "blablabla"));
		author.addArticle(new Article(2, "Article2", "blablabla"));
		author.addArticle(new Article(3, "Article3", "blablabla"));
		
		Map articles = author.getArticles();
		
		assertTrue(articles.containsKey(1));
		assertTrue(articles.containsKey(2));
		assertTrue(articles.containsKey(3));
	}
}
