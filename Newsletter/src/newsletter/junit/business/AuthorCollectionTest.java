package newsletter.junit.business;

import java.util.Map;

import junit.framework.TestCase;
import newsletter.app.business.*;


/**
 * Test class for the authorCollection
 * @author schnl1@bfh.ch
 * @author zumsr1@bfh.ch
 */
public class AuthorCollectionTest extends TestCase{

	
	/**
	 * Tests the add, exists function
	 */
	public void testExists(){
		AuthorCollection authorCollection = AuthorCollection.getInstance();
		
		authorCollection.add("Zumsr1@bfh.ch", "Zumstein", "Ramon");
		
		assertTrue(authorCollection.exists("Zumsr1@bfh.ch"));
	}
	
	/**
	 * Tests the getAuthor function
	 */
	public void testGetAuthor(){
		AuthorCollection authorCollection = AuthorCollection.getInstance();
		
		authorCollection.add("Zumsr1@bfh.ch", "Zumstein", "Ramon");
		
		assertTrue("Zumsr1@bfh.ch".equals(authorCollection.getAuthor("Zumsr1@bfh.ch").getEMailAddress()));
		authorCollection.clear();
	}
	
	/**
	 * Tests the getAllAuthors function
	 */
	public void testGetAllNewsletters(){
		AuthorCollection authorCollection = AuthorCollection.getInstance();
		
		authorCollection.add("Zumsr1@bfh.ch", "Zumstein", "Ramon");
		authorCollection.add("Schnl1@bfh.ch", "Schnyder", "Lars");

		Map authors = authorCollection.getAllAuthors();
		
		assertTrue(authors.containsKey("Zumsr1@bfh.ch"));
		assertTrue(authors.containsKey("Schnl1@bfh.ch"));
	}
	
	/**
	 * Tests the Singelton function
	 */
	public void testSingleton(){
		AuthorCollection authorCollection = AuthorCollection.getInstance();
		
		assertTrue(authorCollection.getAllAuthors().size() > 0);
	}
}
