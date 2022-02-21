import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Answer {
	AnswerCollection mockAnswerCollection;
    public Answer(AnswerCollection mockAnswerCollection) {
        this.mockAnswerCollection = mockAnswerCollection;
    }
    
	protected int id;
	protected int qnsId;
	protected String postBy;
	protected String answers;
	 
	
	//Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	private String jdbcDriver = "com.mysql.jdbc.Driver";
	//Step 2: Prepare list of SQL prepared statements to perform CRUD to database
	private static final String SELECT_QUESTION_BY_ID = "select title, question, username from question where id = ?";
	private static final String SELECT_ALL_ANSWERS = "select * from answers";
	private static final String SELECT_ANSWER_BY_ID = "select id, qnsId, postBy, answers from answers where id = ?";
	private static final String SELECT_ANSWER_BY_QUESTION_ID = "select id, qnsId, postBy, answers from answers where qnsId = ?";
	private static final String UPDATE_ANSWER_SQL = "update answers set qnsId = ?, postBy = ?, answers = ? where id = ?";
	private static final String DELETE_ANSWER_SQL = "delete from answers where id = ?";
	
	
	//Step 3: Implement the getConnection method which facilitates connection to the database via JDBC
		protected Connection getConnection(String url, String username, String password, String driverName) {
			Connection connection = null;
			try {
				Class.forName(driverName);
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
		}
	public Answer(Integer id, Integer qnsId, String postBy, String answers) {
		super();
		this.id = id;
		this.qnsId = qnsId;
		this.postBy = postBy;
		this.answers = answers;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQnsId() {
		return qnsId;
	}
	public void setQnsId(Integer qnsId) {
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
	public List <Answer> getAnswerByQnsId(Integer qnsId) {
		List <Answer> answerList = new ArrayList <>();
		Question existingQuestion = new Question(0,"", "", "");
		//Step 1: Establishing a Connection
				try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
				//Step 2: Create statements using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANSWER_BY_QUESTION_ID);) {
					preparedStatement.setInt(1, qnsId);
					//Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();
					//Step 4: Process the ResultSet object
					while (rs.next()) {
					  int ansId = rs.getInt("id");
					  int qnId = rs.getInt("qnsId");
					  String postBy = rs.getString("postBy");
					  String answer = rs.getString("answers");
					  answerList.add(new Answer(ansId, qnId, postBy, answer));
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				return answerList;
	}
	
	public Question getQuestionById(Integer id) {
		Question existingQuestion = new Question(0,"", "", "");
		//Step 1: Establishing a Connection
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
		//Step 2: Create statements using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTION_BY_ID);) {
			preparedStatement.setInt(1, id);
			//Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			//Step 4: Process the ResultSet object
			while (rs.next()) {
				String title = rs.getString("title");
				String question = rs.getString("question");
				String username = rs.getString("username");
				existingQuestion = new Question(id, title, question, username);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return existingQuestion;
	}
	
	public Question showCreateAnswerForm(Integer qnsId){
		Question existingQuestion = new Question(0,"","","");
		//Step 1: Establishing a Connection
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
		//Step 2: Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTION_BY_ID);) {
			preparedStatement.setInt(1, qnsId);
			//Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			//Step 4: Process the ResultSet object
			while (rs.next()) {
				String title = rs.getString("title");
				String question = rs.getString("question");
				String username = rs.getString("username");
				existingQuestion = new Question(qnsId, title, question, username);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return existingQuestion;
	}
	
	public Answer showEditForm(Integer id) {
		Answer existingAnswer = new Answer(0,0,"","");
		//Step 1: Establishing a Connection
				try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
				//Step 2: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANSWER_BY_ID);) {
					preparedStatement.setInt(1, id);
					//Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();
					//Step 4: Process the ResultSet object
					while (rs.next()) {
						int ansId = rs.getInt("id");
						int qnsId = rs.getInt("qnsId");
						String postBy = rs.getString("postBy");
						String answer = rs.getString("answers");
						existingAnswer = new Answer(ansId, qnsId, postBy, answer);
					}
					return existingAnswer;
				} catch (SQLException e) {
					return null;
				}
				
	}
	
	public boolean createAnswer(Integer id, Integer qnsId, String postBy, String answers, String userId) {
		if(mockAnswerCollection.ifId(userId)) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
			//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into answers values(?,?,?,?)");
			//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
			ps.setInt(1, 0);
			ps.setInt(2, qnsId);
			ps.setString(3, postBy);
			ps.setString(4, answers);
			//Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();
			return true;
				} 
		catch (Exception exception) {
				// TODO Auto-generated catch block
				System.out.println(exception);
				return false;
				} 
		}
		return false;
	}
	
	public boolean editAnswer(Integer qnsId, String postBy, String answer, int id) {
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver); 
				PreparedStatement statement = connection.prepareStatement(UPDATE_ANSWER_SQL);) {
					statement.setInt(1, qnsId);
					statement.setString(2, postBy);
					statement.setString(3, answer);
					statement.setInt(4, id);
					int i = statement.executeUpdate();
					return true;
				} 
		catch (Exception exception) {
			  // TODO Auto-generated catch block
			  System.out.println(exception);
			return false;
						}
	}
	
	public int deleteAnswer(Integer id) {
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
				//Step 2: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ANSWER_BY_ID);) {
					preparedStatement.setInt(1, id);
					//Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();
					//Step 4: Process the ResultSet object
					while (rs.next()) {
						qnsId = rs.getInt("qnsId");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				//Step 2: Attempt connection with database and execute delete answer SQL query
				try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver); 
				PreparedStatement statement = connection.prepareStatement(DELETE_ANSWER_SQL);) {
					statement.setInt(1, id);
					int i = statement.executeUpdate();
					return qnsId;
				}catch (SQLException e) {
					System.out.println(e.getMessage());
					return 0;
				}
			}
	
	
}
