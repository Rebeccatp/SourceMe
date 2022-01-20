

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class tutorialServlet
 */
@WebServlet("/tutorialServlet")
public class tutorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Step 1: Prepare list of variables used for database connections
	 private String jdbcURL = "jdbc:mysql://localhost:3306/sourceMe";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 //Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_TUTORIAL_SQL = "INSERT INTO tutorials" + " (id, title, content) VALUES " + " (?, ?, ?);";
	 private static final String SELECT_TUTORIAL_BY_ID = "select title,content from tutorials where id =?";
	 private static final String SELECT_ALL_TUTORIAL = "select * from tutorials ";
	 private static final String DELETE_TUTORIAL_SQL = "delete from tutorials where id = ?;";
	 private static final String UPDATE_TUTORIAL_SQL = "update tutorials set title = ?,content= ? where id = ?;";
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
    public tutorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter();
		String action = request.getServletPath();
		 try {
		 switch (action) {
		 case "/tutorialServlet/delete":
		 deleteTutorial(request, response);
		 break;
		 case "/tutorialServlet/edit":
		 showEditForm(request, response);
		 break;
		 case "/tutorialServlet/update":
		 updateTutorial(request, response);
		 break;
		 case "/tutorialServlet/dashboard":listTutorials(request, response);
		 break;
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
	}
	
	//Step 5: listUsers function to connect to the database and retrieve all users records
		 private void listTutorials(HttpServletRequest request, HttpServletResponse response)
		 throws SQLException, IOException, ServletException 
		 {
		 List <Tutorial> tutorials = new ArrayList <>();
		  try (Connection connection = getConnection();
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
//		  System.out.print(rs.getInt(1));
		  }
		  } catch (SQLException e) {
		  System.out.println(e.getMessage());
		  }
		 // Step 5.4: Set the users list into the listUsers attribute to be pass to the userManagement.jsp
		 request.setAttribute("listTutorials", tutorials);
//		 System.out.print(tutorials);
		 request.getRequestDispatcher("/tutorial.jsp").forward(request, response);
		 }

		//EDIT FORM		 
		//method to get parameter, query database for existing user data and redirect to user edit page
		 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		 throws SQLException, ServletException, IOException {
		 //get parameter passed in the URL
		 int id = Integer.parseInt(request.getParameter("id"));
		 Tutorial existingTutorial = new Tutorial(0, "", "");
		 // Step 1: Establishing a Connection
		 try (Connection connection = getConnection();
		 // Step 2:Create a statement using connection object
		 PreparedStatement preparedStatement = 
		 connection.prepareStatement(SELECT_TUTORIAL_BY_ID);) {
		 preparedStatement.setInt(1, id);
		 // Step 3: Execute the query or update query
		 ResultSet rs = preparedStatement.executeQuery();
		 // Step 4: Process the ResultSet object 
		 while (rs.next()) {
		 String title = rs.getString("title");
		 String content = rs.getString("content");
		 existingTutorial = new Tutorial(id, title, content);
		 }
		 } catch (SQLException e) {
		 System.out.println(e.getMessage());
		 }
		 //Step 5: Set existingUser to request and serve up the userEdit form
		 request.setAttribute("tutorial", existingTutorial);
		 request.getRequestDispatcher("/tutorialEdit.jsp").forward(request, response);
		 System.out.println(existingTutorial);
		 }

		 //		UPDATE	
		//method to update the user table base on the form data
		 private void updateTutorial(HttpServletRequest request, HttpServletResponse response)
		 throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		 //Step 1: Retrieve value from the request
		 String title = request.getParameter("title");
		  String content = request.getParameter("content");
		  
		  //Step 2: Attempt connection with database and execute update user SQL query
		  try (Connection connection = getConnection(); PreparedStatement statement = 
		 connection.prepareStatement(UPDATE_TUTORIAL_SQL);) {
		  
		  statement.setString(1, title);
		  statement.setString(2, content);
		  statement.setInt(3, id);
		  int i = statement.executeUpdate();
		  }
		  //Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
		  response.sendRedirect("http://localhost:8090/SourceMe/tutorialServlet/dashboard");
		 }

		 //DELETE
		//method to delete user
		 private void deleteTutorial(HttpServletRequest request, HttpServletResponse response)
		 throws SQLException, IOException {
		 //Step 1: Retrieve value from the request
		String id = request.getParameter("id");
		System.out.println("testing:" + id);
		  //Step 2: Attempt connection with database and execute delete user SQL query
		  try (Connection connection = getConnection(); PreparedStatement statement = 
		 connection.prepareStatement(DELETE_TUTORIAL_SQL);) {
			  statement.setString(1, id);
		  int i = statement.executeUpdate();
		  }
		  //Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
		  response.sendRedirect("http://localhost:8090/SourceMe/tutorialServlet/dashboard");
		 }



}
