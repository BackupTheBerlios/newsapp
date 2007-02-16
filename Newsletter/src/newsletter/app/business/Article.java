package newsletter.app.business;

public class Article {
	private String title;
	private String text;
	private Issue issue;
	private int id;
	private static int actId = 0;

	public Article(String title, String text){
		this.id = ++actId;
		this.title = title;
		this.text = text;
	}
	
	public void setIssue(Issue issue){
		this.issue = issue;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public String getText(){
		return this.text;
	}
	
	public Issue getIssue(){
		return this.issue;
	}
}