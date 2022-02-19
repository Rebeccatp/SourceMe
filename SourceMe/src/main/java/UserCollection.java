import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCollection {
	
    public UserCollection() {
    }
	
	//Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	private static final String SELECT_USER_BY_ID = "select role, firstName, lastName, number, userName, password, email from user where id = ?";
	private static final String DELETE_USER = "delete from user where id = ?";
	private static final String UPDATE_USER = "update user set role = ?, firstName = ?, lastName = ?, number = ?, password = ?, email = ? where id = ?";
	//Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
	protected Connection getConnection() {
	Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public String createUser(String role, String firstname, String lastname, String number, String username, String password, String email) {
		String msg = "";
		//Step 3: attempt connection to database using JDBC
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
			PreparedStatement ps1 = con.prepareStatement("select id from user where userName = ?");
			ps1.setString(1, username);
			ResultSet rs1 = ps1.executeQuery();
			String idExisting = "";
			while (rs1.next()) {
				idExisting = rs1.getString("id");
			}
			if (!(isNumeric(idExisting))) {
				try {
					//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
					PreparedStatement ps2 = con.prepareStatement("insert into USER values(?,?,?,?,?,?,?,?)");
					//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
					ps2.setInt(1, 0);
					ps2.setString(2, role);
					ps2.setString(3, firstname);
					ps2.setString(4, lastname);
					ps2.setString(5, number);
					ps2.setString(6, username);
					ps2.setString(7, password);
					ps2.setString(8, email);
					//Step 6: perform the query on the database using the prepared statement
					int i2 = ps2.executeUpdate();
					//Step 7: check if the query had been successfully executed, return You are successfully registered via the response
					if (i2 > 0) {
						msg = "success";
					}
				}
				//Step 8: catch and print out any exception
				catch (Exception exception) {
					msg = "connection failed";
				}
			}
			else {
				msg = "username already exists";
			}
		} catch (Exception exception) {
			msg = "connection failed";
		}
		return msg;
	}
	
	public User getUserById(String idString) {
		User existingUser = new User(0, "", "", "", "", "", "", "");
		//Get userId from session storage
		int id = Integer.parseInt(idString);
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
		// Step 2: Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				String role = rs.getString("role");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String number = rs.getString("number");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String email = rs.getString("email");
				existingUser = new User(id, role, firstName, lastName, number, userName, password, email);
			}
		} catch (SQLException e) {
		}
		return existingUser;
	}
	
	public boolean updateUserById(String idString, String role, String firstname, String lastname, String number, String password, String email) {
		boolean result = false;
		int id = Integer.parseInt(idString);
		//Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection(); 
		PreparedStatement statement = connection.prepareStatement(UPDATE_USER);) {
			statement.setString(1, role);
			statement.setString(2, firstname);
			statement.setString(3, lastname);
			statement.setString(4, number);
			statement.setString(5, password);
			statement.setString(6, email);
			statement.setInt(7, id);
			int i = statement.executeUpdate();
			if (i > 0) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}
	
	public boolean deleteUserById(String idString) {
		boolean result = false;
		//Step 1: Retrieve value from the request
		int id = Integer.parseInt(idString);
		//Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection(); 
		PreparedStatement statement = connection.prepareStatement(DELETE_USER);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
			if (i > 0) {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
		}
		return result;
	}
	
	public String login(String username, String password) {
		String msg = "";
		String idExisting = "";
		String userNameExisting = "";
		String roleExisting ="";
		//Step 3: attempt connection to database using JDBC
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
			PreparedStatement ps1 = con.prepareStatement("select id, userName, role from user where userName = ? and password = ?");
			ps1.setString(1, username);
			ps1.setString(2, password);
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				idExisting = rs1.getString("id");
				userNameExisting = rs1.getString("userName");
				roleExisting = rs1.getString("role");
			}
			if (isNumeric(idExisting)) {				
				msg = idExisting;
			}
			else {
				msg = "wrong username or password";
			}
		} catch (Exception exception) {
			msg = "connection failed";
		}
		return msg;
	}
	
	public static boolean isNumeric(String idString) {
	    int idInt;
	    try {
	    	idInt = Integer.parseInt(idString);
	        return true;
	    } catch (NumberFormatException e) {
	    }
	    return false;
	}

}
