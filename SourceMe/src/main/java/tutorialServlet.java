

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
	 private String jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
	 private String jdbcUsername = "root";
	 private String jdbcPassword = "password";
	 //Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails" + " (name, password, email, language) VALUES " + " (?, ?, ?);";
	 private static final String SELECT_USER_BY_ID = "select name,password,email,language from UserDetails where name =?";
	 private static final String SELECT_ALL_USERS = "select * from UserDetails ";
	 private static final String DELETE_USERS_SQL = "delete from UserDetails where name = ?;";
	 private static final String UPDATE_USERS_SQL = "update UserDetails set name = ?,password= ?, email =?,language =? where name = ?;";
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
