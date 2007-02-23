package newsletter.app.business;

/**
 * Controller for all articles
 * @author schnl1, zumsr1
 *
 */
public class ArticleController {
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	
	/**
	 * get the title of an article
	 * @param newsletterName newsletter name
	 * @param articleId article id
	 * @return araticle title
	 */
	public String getArticleTitle(String newsletterName, int articleId){
		return newsletterCollection.getNewsletter(newsletterName).getArticle(articleId).getTitle();
	}
	
	/**
	 * get the text of an article
	 * @param newsletterName newsletter name
	 * @param articleId article id
	 * @return article text
	 */
	public String getArticleText(String newsletterName, int articleId){
		return newsletterCollection.getNewsletter(newsletterName).getArticle(articleId).getText();
	}
}
