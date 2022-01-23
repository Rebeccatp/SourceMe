
public class Question {
	protected Integer id;
	public Question(Integer id, String title, String question, String username) {
		super();
		this.id = id;
		this.title = title;
		this.question = question;
		this.username = username;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	protected String title;
	protected String question;
	protected String username;
}
