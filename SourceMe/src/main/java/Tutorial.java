public class Tutorial {
	protected Number id;
	protected String title;
	protected String content;
	
	public Tutorial(Number id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
