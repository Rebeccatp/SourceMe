

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	private static final String SELECT_USER_BY_ID = "select firstName,lastName,number,userName,password,email from user where id = ?;";
	private static final String DELETE_USER = "delete from user where id = ?;";
	private static final String UPDATE_USER = "update user set firstName = ?, lastName = ?, number = ?, userName = ?, password = ?, email = ? where id = ?;";
	
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
/**
				case "/UserServlet/delete":
					deleteUser(request, response);
					break;
*/
				case "/UserServlet/edit":
					showEditForm(request, response);
					break;
				case "/UserServlet/update":
					updateUser(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//method to get parameter, query database for existing user data and redirect to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//get parameter passed in the URL
		//int id = Integer.parseInt(request.getParameter("id"));
		int id = 1;
		User existingUser = new User(0, "", "", "", "", "", "");

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
		// Step 2: Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String number = rs.getString("number");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				String email = rs.getString("email");
				existingUser = new User(id, firstName, lastName, number, userName, password, email);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("user", existingUser);
		request.getRequestDispatcher("/updateProfile.jsp").forward(request, response);
	}
	
	//method to update the user table base on the form data
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Retrieve value from the request
		//int id = Integer.parseInt(request.getParameter("id"));
		int id = 1;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String number = request.getParameter("number");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
	
		//Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection(); PreparedStatement statement =
			connection.prepareStatement(UPDATE_USER);) {
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, number);
			statement.setString(4, userName);
			statement.setString(5, password);
			statement.setString(6, email);
			statement.setInt(7, id);
			int i = statement.executeUpdate();
		}
		//Step 3: redirect back to UserServlet (note: remember to change the url to your project name)
/**
		response.sendRedirect("http://localhost:8090/HelloWorldJavaEE/UserServlet/dashboard");
*/
		//refresh update profile page
		response.setHeader("Refresh", "0; URL=http://localhost:8090/SourceMe/UserServlet/edit");
	}

}
