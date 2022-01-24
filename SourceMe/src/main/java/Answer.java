
public class Answer {
	 protected int id;
	 public Answer(int id, int qnsId, String postBy, String answers) {
		super();
		this.id = id;
		this.qnsId = qnsId;
		this.postBy = postBy;
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
	public String getPostBy() {
		return postBy;
	}
	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	protected int qnsId;
	 protected String postBy;
	 protected String answers;
	 
}
