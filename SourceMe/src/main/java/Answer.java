
public class Answer {
	 protected int id;
	 public Answer(int id, int qnsId, String username, String answers) {
		super();
		this.id = id;
		this.qnsId = qnsId;
		this.username = username;
		this.answers = answers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQnsId() {
		return qnsId;
	}
	public void setQnsId(int qnsId) {
		this.qnsId = qnsId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	protected int qnsId;
	 protected String username;
	 protected String answers;
	 
}
