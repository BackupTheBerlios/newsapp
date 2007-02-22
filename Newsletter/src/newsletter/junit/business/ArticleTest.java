package newsletter.junit.business;


import java.util.Date;
import junit.framework.TestCase;
import newsletter.app.business.Article;
import newsletter.app.business.Issue;
import newsletter.app.business.Newsletter;


public class ArticleTest extends TestCase{

	public void testConstructorId(){
		Article article1 = new Article("Artikel1", "Text1");
		Article article2 = new Article("Artikel2", "Text2");
		Article article3 = new Article("Artikel3", "Text3");
		assertTrue(article1.getId() == 1);
		assertTrue(article2.getId() == 2);
		assertTrue(article3.getId() == 3);
	}
	
	public void testConstructorTitle(){
		Article article = new Article("Artikel1", "Text1");
		assertTrue("Artikel1".equals(article.getTitle()));
	}
	
	public void testConstructorText(){
		Article article = new Article("Artikel1", "Text1");
		assertTrue("Text1".equals(article.getText()));
	}
	
	public void testSetGetTitle(){
		Article article1 = new Article("Artikel1", "Text1");
		article1.setTitle("testArtikel");
		assertTrue("testArtikel".equals(article1.getTitle()));
	}

	public void testSetGetText(){
		Article article1 = new Article("Artikel1", "Text1");
		article1.setText("testText");
		assertTrue("testText".equals(article1.getText()));
	}

	public void testSetGetIssue(){
		Article article1 = new Article("Artikel1", "Text1");
		Issue issue = new Issue(1,new Date(),new Newsletter("Newsletter","Description",1));
		article1.setIssue(issue);
		assertTrue(issue.equals(article1.getIssue()));
	}
}