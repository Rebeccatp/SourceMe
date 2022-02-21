public class User {
	protected int id;
	protected String role;
	protected String firstName;
	protected String lastName;
	protected String number;
	protected String userName;
	protected String password;
	protected String email;

	public User(int id, String role, String firstName, String lastName, String number, String userName, String password, String email) {
		super();
		this.id = id;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isNumeric(String idString) {
	    int idInt;
	    try {
	    	idInt = Integer.parseInt(idString);
	        return true;
	    } catch (NumberFormatException e) {
	    }
	    return false;
	}
}