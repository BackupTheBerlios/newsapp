package newsletter.app.business;

public class ArticleController {
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance();
	
	public String getArticleTitle(String newsletterName, int articleId){
		return newsletterCollection.getNewsletter(newsletterName).getArticle(articleId).getTitle();
	}
	
	public String getArticleText(String newsletterName, int articleId){
		return newsletterCollection.getNewsletter(newsletterName).getArticle(articleId).getText();
	}
}
