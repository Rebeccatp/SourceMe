
public class question {
	protected String title;
	 protected String question;
	 protected String username;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public question(String title, String question, String username) {
		super();
		this.title = title;
		this.question = question;
		this.username = username;
	}
	
}
