package newsletter.app.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EditorController {
	private NewsletterCollection newsletterCollection = NewsletterCollection.getInstance(); 
	
	public List getAllUnlinkedArticles(String newsletterName){
		ArrayList arrReturn = new ArrayList();
		return arrReturn;
	}
	
	public int newArticle(String title, String text, String newsletterName){
		Article article = new Article(title, text);
		newsletterCollection.getNewsletter(newsletterName).addArticle(article);
		return article.getId();
	}
	
	public void setAuthorToArticle(String newsletterName, String articleId, String authorId){
		
	}
	
	public void setArticleToOpenIssue(String newsletterName, int articleId){
		newsletterCollection.getNewsletter(newsletterName).setArticleToOpenIssue(articleId);
	}
	
	public int compileIssueAndCreateNew(String newsletterName, int year, Date publishingDate){
		return newsletterCollection.getNewsletter(newsletterName).compileIssueAndCreateNew(year, publishingDate).getId();
	}
}
