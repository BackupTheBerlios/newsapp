package newsletter.junit.business;


import java.util.Date;
import junit.framework.TestCase;
import newsletter.app.business.Article;
import newsletter.app.business.Issue;
import newsletter.app.business.Newsletter;

/**
 * Test class for the article
 * @author schnl1@bfh.ch
 * @author zumsr1@bfh.ch
 */
public class ArticleTest extends TestCase{

	/**
	 * Test the constructor creation of the id
	 */
	public void testConstructorId(){
		Article article1 = new Article(1, "Artikel1", "Text1");
		Article article2 = new Article(2, "Artikel2", "Text2");
		Article article3 = new Article(3, "Artikel3", "Text3");
		assertTrue(article1.getId() == 1);
		assertTrue(article2.getId() == 2);
		assertTrue(article3.getId() == 3);
	}
	
	/**
	 * Tests the constructor creation of the title
	 */
	public void testConstructorTitle(){
		Article article = new Article(1,"Artikel1", "Text1");
		assertTrue("Artikel1".equals(article.getTitle()));
	}
	
	/**
	 * Tests the constructor creation of the text
	 */
	public void testConstructorText(){
		Article article = new Article(1, "Artikel1", "Text1");
		assertTrue("Text1".equals(article.getText()));
	}
	
	/**
	 * Tests the title setter and getter methods of the class
	 */
	public void testSetGetTitle(){
		Article article1 = new Article(1, "Artikel1", "Text1");
		article1.setTitle("testArtikel");
		assertTrue("testArtikel".equals(article1.getTitle()));
	}

	/**
	 * Tests the text setter and gettter methods of the class
	 */
	public void testSetGetText(){
		Article article1 = new Article(1, "Artikel1", "Text1");
		article1.setText("testText");
		assertTrue("testText".equals(article1.getText()));
	}

	/**
	 * Tests the issue setter and gettter methods of the class
	 */
	public void testSetGetIssue(){
		Article article1 = new Article(1, "Artikel1", "Text1");
		Issue issue = new Issue(1, 2007, new Date(),new Newsletter("Newsletter","Description",1));
		article1.setIssue(issue);
		assertTrue(issue.equals(article1.getIssue()));
	}
	
	
	/**
	 * Tests the equals method of the class
	 */
	public void testEquals(){
		Article article1 = new Article(1, "Artikel1", "Text1");
		Article article2 = new Article(1, "Artikel1", "Text1");
		Article article3 = new Article(3, "Artikel3", "Text3");
		
		assertTrue(article1.equals(article2));
		assertFalse(article1.equals(article3) || article2.equals(article3));
	}
}