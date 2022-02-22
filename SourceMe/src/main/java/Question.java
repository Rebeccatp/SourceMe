import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Question {
	//Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	private static final String INSERT_QUESTIONS_SQL = "INSERT INTO question" + " (title, question, username) VALUES " +
	" (?, ?, ?);";
	private static final String SELECT_QUESTION_BY_ID = "select id, title, question, username from question where id =?";
	private static final String SELECT_ALL_QUESTIONS = "select * from question ";
	private static final String DELETE_QUESTIONS_SQL = "delete from question where id = ?;";
	private static final String UPDATE_QUESTIONS_SQL = "update question set title = ?,question= ?, username = ? where id = ?;";
	
  //Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
	protected Connection getConnection() {
	Connection connection = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	} catch (SQLException e) {
	e.printStackTrace();
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	return connection;
	}
  

	protected int id;
	protected String title;
	protected String question;
	protected String username;
  
	public Question(int id, String title, String question, String username) {
		super();
		this.id = id;
		this.title = title;
		this.question = question;
		this.username = username;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	//function to retrieve all the questions
	public List<Question> getAllQuestions() {
		List <Question> questions = new ArrayList <>();
		try (Connection connection = getConnection();
		//Step 5.1: Create a statement using connection object
		PreparedStatement preparedStatement =
		connection.prepareStatement(SELECT_ALL_QUESTIONS);) {
		//Step 5.2: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
		//Step 5.3: Process the ResultSet object.
		while (rs.next()) {
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String question = rs.getString("question");
		String username = rs.getString("username");
		questions.add(new Question(id, title, question, username));
		}
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		} return questions;
	}

	//function to get a question based on its id
	public Question getQuestionByID(int id) {
		Question existingQuestion = new Question(id, "", "", "");
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTION_BY_ID);) {
			preparedStatement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				id = rs.getInt("id");
				String username = rs.getString("username");
				String title = rs.getString("title");
				String question = rs.getString("question");
				existingQuestion = new Question(id, title, question, username);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return existingQuestion;
	}
	
	//add question function
	public boolean addQuestion(String title, String question, String username ) {
	try {
				 Class.forName("com.mysql.jdbc.Driver");
				 Connection con = DriverManager.getConnection(
				 "jdbc:mysql://localhost:3306/sourceme", "root", "password");
				//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
				 PreparedStatement ps = con.prepareStatement("insert into question values(?,?,?,?)");
				//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
				ps.setInt(1, 0);
				 ps.setString(2, title);
				 ps.setString(3, question);
				 ps.setString(4, username);
				//Step 6: perform the query on the database using the prepared statement
				 int i = ps.executeUpdate();
				//Step 7: check if the query had been successfully execute, return �question added� via the response,
				 //Step 7: Check if the query had been successfully execute, return “You have successfully created a tutorial!” via the response
				 if (i > 0) {
				 return true;
				 } else {
				 return false;
				 }
				 }
				 //Step 8: catch and print out any exception
				 catch (Exception exception) {
				 System.out.println(exception);
				 return false;
				 }
	}

	//update question
	//method to get parameter, query database for existing question data and redirect to question edit page
	public boolean updateQn(String title, String question, String username, int id) {

		//Step 1: Establishing a Connection
		try (Connection connection = getConnection(); 
			PreparedStatement statement = connection.prepareStatement(UPDATE_QUESTIONS_SQL);) {
			statement.setString(1, title);
			statement.setString(2, question);
			statement.setString(3, username);
			statement.setInt(4, id);
			int i = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	//delete qn
	public boolean deleteQn(int questionId) {
		int id = questionId; // Step 2: Attempt connection with database and execute delete question SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_QUESTIONS_SQL);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
			
			 if (i > 0) {
				 return true;
				 } else {
				 return false;
				 }
			 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
