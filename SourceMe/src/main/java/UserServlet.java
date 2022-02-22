import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

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
				case "/UserServlet/edit": showEditForm(request, response);
				break;
				case "/UserServlet/login": loginUser(request, response);
				break;
				case "/UserServlet/loginPage": loginPage(request, response);
				break;
				case "/UserServlet/register": registerUser(request, response);
				break;
				case "/UserServlet/registerPage": registerPage(request, response);
				break;
				case "/UserServlet/update": updateUser(request, response);
				break;
				case "/UserServlet/delete": deleteUser(request, response);
				break;
				case "/UserServlet/logout": logoutUser(request, response);
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
	
	//Method to get parameter, query database for existing user data and redirect to user edit page
	public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//Get userId from session storage
		HttpSession session = request.getSession();
		String idString = (String) session.getAttribute("userId");
		if (idString != null) {
			int id = Integer.parseInt(idString);
			User existingUser = new User(0, "", "", "", "", "", "", "");
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
				System.out.println(e.getMessage());
			}
			//Step 5: Set existingUser to request and serve up the userEdit form
			request.setAttribute("user", existingUser);
			request.getRequestDispatcher("/updateProfile.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("loginPage");
		}
	}
	
	// create login form		 
	public void loginPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	// create register form		 
	public void registerPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}
	
	// Login
	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		//Step 2: retrieve the two parameters from the request from the web form
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		//Step 3: attempt connection to database using JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
			PreparedStatement ps1 = con.prepareStatement("select id, userName, role from user where userName = ? and password = ?");
			ps1.setString(1, userName);
			ps1.setString(2, password);
			ResultSet rs1 = ps1.executeQuery();
			String idExisting = "";
			String userNameExisting = "";
			String roleExisting ="";
			while (rs1.next()) {
				idExisting = rs1.getString("id");
				userNameExisting = rs1.getString("userName");
				roleExisting = rs1.getString("role");
			}
			if (isNumeric(idExisting)) {				
				HttpSession session = request.getSession();
				session.setAttribute("userId", idExisting);
				session.setAttribute("userName", userNameExisting);
				session.setAttribute("role", roleExisting);
				//Step 3: direct to UserServlet update profile page
				response.sendRedirect("edit");
			}
			else {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "Wrong username or password!" + "</h1>");
				writer.close();
			}
		} catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}	
	}
	
	//Register
	public void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		//Step 2: retrieve the six parameters from the request from the web form
		String role = request.getParameter("role");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String number = request.getParameter("number");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//Step 3: attempt connection to database using JDBC
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
			PreparedStatement ps1 = con.prepareStatement("select id from user where userName = ?");
			ps1.setString(1, userName);
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
					ps2.setString(3, firstName);
					ps2.setString(4, lastName);
					ps2.setString(5, number);
					ps2.setString(6, userName);
					ps2.setString(7, password);
					ps2.setString(8, email);
					//Step 6: perform the query on the database using the prepared statement
					int i2 = ps2.executeUpdate();
					//Step 7: check if the query had been successfully executed, return You are successfully registered via the response
					if (i2 > 0) {
						//Step 3: redirect back to UserServlet login page
						response.sendRedirect("loginPage");
					}
				}
				//Step 8: catch and print out any exception
				catch (Exception exception) {
					System.out.println(exception);
					out.close();
				}
			}
			else {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "Username already exists!" + "</h1>");
				writer.close();
			}
		} catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}		
	}
	
	public boolean isNumeric(String idString) {
	    int idInt;
	    try {
	    	idInt = Integer.parseInt(idString);
	        return true;
	    } catch (NumberFormatException e) {
	    	System.out.println(e);
	    }
	    return false;
	}
	
	//Method to update the user table base on the form data
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {		
		HttpSession session = request.getSession();
		String idString = (String) session.getAttribute("userId");
		int id = Integer.parseInt(idString);
		String role = request.getParameter("role");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection(); 
		PreparedStatement statement = connection.prepareStatement(UPDATE_USER);) {
			statement.setString(1, role);
			statement.setString(2, firstName);
			statement.setString(3, lastName);
			statement.setString(4, number);
			statement.setString(5, password);
			statement.setString(6, email);
			statement.setInt(7, id);
			int i = statement.executeUpdate();
		}
		//Refresh update profile page
		response.setHeader("Refresh", "0; URL=edit");
	}
	
	//Method to delete user
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession();
		//Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));
		//Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection(); 
		PreparedStatement statement = connection.prepareStatement(DELETE_USER);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
		}
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.removeAttribute("role");
		//Step 3: redirect back to UserServlet register page
		response.sendRedirect("registerPage");
	}
	
	public void logoutUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		session.removeAttribute("role");
		//Step 3: redirect back to UserServlet login page
		response.sendRedirect("loginPage");
	}
}