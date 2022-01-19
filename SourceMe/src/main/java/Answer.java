
public class Answer {
	 protected int id;
	 public Answer(int id, int qnsId, String answer) {
		super();
		this.id = id;
		this.qnsId = qnsId;
		this.answer = answer;
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	protected int qnsId;
	 protected String answer;
}
