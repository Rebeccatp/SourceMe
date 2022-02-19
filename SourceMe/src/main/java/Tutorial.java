import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tutorial {
	
	
	//Step 1: Prepare list of variables used for database connections
		private String jdbcURL = "jdbc:mysql://localhost:3306/sourceMe";
		private String jdbcUsername = "root";
		private String jdbcPassword = "password";
		private String classname = "com.mysql.jdbc.Driver";
		//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
		private static final String INSERT_TUTORIAL_SQL = "insert into tutorials" + " (id, title, content) values " + " (?,?,?);";
		private static final String SELECT_TUTORIAL_BY_ID = "select title,content from tutorials where id =?";
		private static final String SELECT_ALL_TUTORIAL = "select * from tutorials ";
		private static final String DELETE_TUTORIAL_SQL = "delete from tutorials where id = ?;";
		private static final String UPDATE_TUTORIAL_SQL = "update tutorials set title = ?,content= ? where id = ?;";
		//Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
		protected Connection getConnection(String url,String username,String password, String classname) {
			Connection connection = null;
			try {
				Class.forName(classname);
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
		 }
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
	
	public List<Tutorial> getAllTutorials(){
		List <Tutorial> tutorials = new ArrayList <>();
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword,classname);
		// Step 5.1: Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TUTORIAL);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				Number id = rs.getInt(1);
				String title = rs.getString("title");
				String content = rs.getString("content");
				tutorials.add(new Tutorial(id, title, content));
			}return tutorials;	
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Tutorial getTutorialById(Integer tutorialid) {
		Tutorial existingTutorial = new Tutorial(0, "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword,classname);
		// Step 2: Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TUTORIAL_BY_ID);) {
			preparedStatement.setInt(1, tutorialid);
			if(tutorialid>0) {
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();
				// Step 4: Process the ResultSet object 
				while (rs.next()) {
					String title = rs.getString("title");
					String content = rs.getString("content");
					existingTutorial = new Tutorial(tutorialid, title, content);
				}
				return existingTutorial;
			}
			return null;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}		
	}
	
	public boolean createTutorial(String title, String content) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
			//Step 4: Implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into tutorials values(?,?,?)");
			//Step 5: Parse in the data retrieved from the web form request into the prepared statement accordingly
			ps.setInt(1, 0);
			ps.setString(2, title);
			ps.setString(3, content);
			//Step 6: Perform the query on the database using the prepared statement
			int i = ps.executeUpdate();
			System.out.println(i);
			//Step 7: Check if the query had been successfully execute, return “You have successfully created a tutorial!” via the response
			return true;
		}
		//Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			return false;
		}
		
	}
	
	public boolean updateTutorialById(Integer tutorialid, String updateTitle, String updateContent) {

		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, classname);
				PreparedStatement statement = connection.prepareStatement(UPDATE_TUTORIAL_SQL);) {
					statement.setString(1, updateTitle);
					statement.setString(2, updateContent);
					statement.setInt(3, tutorialid);
					int i = statement.executeUpdate();
				return true;
					
				} catch (Exception exception) {
					// TODO Auto-generated catch block
					System.out.println(exception);
					return false;
				}
	}
	
	public boolean deleteTutorialById(Integer tutorialid) {
		//Step 2: Attempt connection with database and execute delete tutorial SQL query
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, classname); 
		PreparedStatement statement = connection.prepareStatement(DELETE_TUTORIAL_SQL);) {
			statement.setInt(1, tutorialid);
			int i = statement.executeUpdate();
			return true;
		}catch (Exception exception) {
			// TODO Auto-generated catch block
			System.out.println(exception);
			return false;
		}
	}
}
