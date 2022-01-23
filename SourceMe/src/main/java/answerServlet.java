

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createAnswerServlet
 */
@WebServlet("/AnswerServlet")
public class answerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Step 1: Prepare list of variables used for database connections
	 private String jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 //Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_QUESTIONS_SQL = "INSERT INTO question" + " (title, question, username) VALUES " +
	 " (?, ?, ?);";
	 private static final String SELECT_QUESTION_BY_USERNAME = "select title, question, username from question where username =?";
	 private static final String SELECT_QUESTION_BY_ID = "select title, question, username from question where id =?";
	 private static final String SELECT_ALL_QUESTIONS = "select * from question";
	 private static final String DELETE_QUESTIONS_SQL = "delete from question where username = ?;";
	 private static final String UPDATE_QUESTIONS_SQL = "update question set title = ?,question= ?, username = ?;";
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
    public answerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter();
		
		//Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.
				String action = request.getServletPath();
				 try {
				 switch (action) {
				 case "/answerServlet/addAnswer": addAnswer(request, response);
				 break;
				/*
				 * case "/delete": break; case "/edit": break; case "/update": break; case
				 * "/questionServlet/viewAnswer": viewAnswer(request, response); break; case
				 * "/questionServlet/dashboard":listQuestions(request, response); break;
				 */
				 }
				 } catch (SQLException ex) {
				 throw new ServletException(ex);
				 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		
		//Step 2: retrieve the three parameters from the request from the web form
		int qnsId = Integer.parseInt(request.getParameter("qnsId"));
		String username = request.getParameter("username");
		String answers = request.getParameter("answer");
		System.out.print(answers);
		//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
		 
		//Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
		PreparedStatement ps = con.prepareStatement("insert into answers values(?,?,?,?)");
		
		//Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
		 ps.setInt(1, 0);
		 ps.setInt(2, qnsId);
		 ps.setString(3, username);
		 ps.setString(4, answers);
		 System.out.print("testing");

		//Step 6: perform the query on the database using the prepared statement
		 int i = ps.executeUpdate();
		 
		
		 
		//Step 7: check if the query had been successfully execute, return “You are successfully registered” via the response,
		 if (i > 0){
				  PrintWriter writer = response.getWriter(); 
				  writer.println("<h1>" + "You have successfully inserted the answer!" +"</h1>"); 
				  writer.close();
			 }
		}
		
		//Step 8: catch and print out any exception
		catch (Exception exception) {
		 System.out.println(exception);
		 out.close();
		}
		
	}
	
	// create tutorial form
	private void addAnswer(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, ServletException, IOException {
		//get parameter passed in the URL
		int qnsId = Integer.parseInt(request.getParameter("qnsId"));
		 System.out.println(qnsId); 
		Question existingQuestion = new Question(0,"", "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
		// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement =
		connection.prepareStatement(SELECT_QUESTION_BY_ID);) {
		preparedStatement.setInt(1, qnsId);
		System.out.println(qnsId);
		// Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
		// Step 4: Process the ResultSet object
		while (rs.next()) {
		 String title = rs.getString("title");
		 String question = rs.getString("question");
		 String username = rs.getString("username");
		 
		 existingQuestion = new Question(qnsId,title, question, username);
		}
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
		System.out.println(existingQuestion);
		request.setAttribute("question", existingQuestion);
	request.getRequestDispatcher("/createAnswer.jsp").forward(request, response);
	}

}
