import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
* Servlet implementation class questionServlet
*/
@WebServlet("/questionServlet")
public class questionServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

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

/**
* @see HttpServlet#HttpServlet()
*/
public questionServlet() {
super();
// TODO Auto-generated constructor stub
}



/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.
String action = request.getServletPath();
try {
switch (action) {
case "/questionServlet/delete":
deleteQuestion(request, response);
break;
case "/questionServlet/questionForm":
	showQuestionForm(request, response);
break;
case "/questionServlet/createQuestion": 
	createQuestion(request, response);
break;
case "/questionServlet/edit":
showEditForm(request, response);
break;
case "/questionServlet/update":
updateQuestion(request, response);
break;
case "/questionServlet/questions":
listQuestions(request, response);
break;
}
} catch (SQLException ex) {
throw new ServletException(ex);
}

// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}



/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}

//Step 5: listQuestion function to connect to the database and retrieve all question records
private void listQuestions(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException, ServletException
{
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
}
//Step 5.4: Set the question list into the listQuestion attribute to be pass to the questionManagement.jsp
request.setAttribute("listQuestions", questions);
request.getRequestDispatcher("/questionManagement.jsp").forward(request, response);
}

private void showQuestionForm(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
	HttpSession session = request.getSession();
	String idString = (String) session.getAttribute("userId");
	if (idString != null) {
		request.getRequestDispatcher("/questions.jsp").forward(request, response);
	}
else {
	response.sendRedirect("http://localhost:8090/SourceMe/UserServlet/loginPage");
}
		}


//method to get parameter, query database for existing question data and redirect to question edit page
private void showEditForm(HttpServletRequest request, HttpServletResponse response)
throws SQLException, ServletException, IOException {
//get parameter passed in the URL
int id = Integer.parseInt(request.getParameter("id"));
Question existingQuestion = new Question(id , "", "", "");
//Step 1: Establishing a Connection
try (Connection connection = getConnection();
//Step 2:Create a statement using connection object
PreparedStatement preparedStatement =
connection.prepareStatement(SELECT_QUESTION_BY_ID);) {
preparedStatement.setInt(1, id);
//Step 3: Execute the query or update query
ResultSet rs = preparedStatement.executeQuery();
//Step 4: Process the ResultSet object
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
//Step 5: Set existingQuestion to request and serve up the questionEdit form
request.setAttribute("currentQuestion", existingQuestion);
System.out.println(id);
request.getRequestDispatcher("/editQuestion.jsp").forward(request, response);
}

private void createQuestion(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException {
	
	HttpSession session = request.getSession();
	String userName = (String) session.getAttribute("userName");
	
	//Step 1: Initialize a PrintWriter object to return the html values via the response
			PrintWriter out = response.getWriter();
			//Step 2: retrieve the three parameters from the request from the web form
			String t = request.getParameter("title");
			String q = request.getParameter("question");
			String u = userName;
			//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
			try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/sourceme", "root", "password");
			//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			 PreparedStatement ps = con.prepareStatement("insert into question values(?,?,?,?)");
			//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
			ps.setInt(1, 0);
			 ps.setString(2, t);
			 ps.setString(3, q);
			 ps.setString(4, u);
			//Step 6: perform the query on the database using the prepared statement
			 int i = ps.executeUpdate();
			//Step 7: check if the query had been successfully execute, return “question added” via the response,
			 if (i > 0){
			PrintWriter writer = response.getWriter();
			writer.println("<br>");
			writer.println("<a href='http://localhost:8090/SourceMe/questionServlet/questions' style='color: #9A9A9A; text-decoration:none;'>" 
			+ "Back to main" + 
					"</a>");
			writer.println("<h1 style='text-align: center; color: #586BA4; margin-top: 190px'>" + "Your question has been added!" + 
			"</h1>");
			writer.println("<h3 style='text-align: center; color: #586BA4'>" + "To view it, click on 'Back to main' which is "
					+ "located at the top left of the screen to go back to the list of question page" + 
			"</h3>");
			writer.close(); 
			} 
			}
			//Step 8: catch and print out any exception
			catch (Exception exception) {
			 System.out.println(exception);
			 out.close();
			}
	

		}



//method to update the question table base on the form data
private void updateQuestion(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException {
//Step 1: Retrieve value from the request
int oriId = Integer.parseInt(request.getParameter("oriId"));
String username = request.getParameter("username");
String title = request.getParameter("title");
String question = request.getParameter("question");


//Step 2: Attempt connection with database and execute update question SQL query
try (Connection connection = getConnection(); PreparedStatement statement =
connection.prepareStatement(UPDATE_QUESTIONS_SQL);) {
statement.setString(1, title);
statement.setString(2, question);
statement.setString(3, username);
statement.setInt(4, oriId);
int i = statement.executeUpdate();
}
//Step 3: redirect back to questionServlet (note: remember to change the url to your project name)
response.sendRedirect("http://localhost:8090/SourceMe/questionServlet/questions");
}

//method to delete question
private void deleteQuestion(HttpServletRequest request, HttpServletResponse response)
throws SQLException, IOException {
//Step 1: Retrieve value from the request
int id = Integer.parseInt(request.getParameter("id")); //Step 2: Attempt connection with database and execute delete question SQL query
try (Connection connection = getConnection(); PreparedStatement statement =
connection.prepareStatement(DELETE_QUESTIONS_SQL);) {
statement.setInt(1, id);
int i = statement.executeUpdate();
}
//Step 3: redirect back to questionServlet main page (note: remember to change the url to your project name)
response.sendRedirect("http://localhost:8090/SourceMe/questionServlet/questions");
}











}