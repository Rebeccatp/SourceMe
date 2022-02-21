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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
				case "/tutorialServlet/create": createTutorial(request, response);
				break;
				case "/tutorialServlet/delete": deleteTutorial(request, response);
				break;
				case "/tutorialServlet/createTutorials": createTutorials(request, response);
				break;
				case "/tutorialServlet/edit": showEditForm(request, response);
				break;
				case "/tutorialServlet/update": updateTutorial(request, response);
				break;
				case "/tutorialServlet/dashboard": listTutorials(request, response);
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
	protected void listTutorials(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
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
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the users list into the listUsers attribute to be pass to the userManagement.jsp
		request.setAttribute("listTutorials", tutorials);
		request.getRequestDispatcher("/tutorial.jsp").forward(request, response);
	 }

	//EDIT FORM		 
	//method to get parameter, query database for existing tutorial data and redirect to tutorialEdit page
	protected void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//get parameter passed in the URL
		int id = Integer.parseInt(request.getParameter("id"));

		System.out.println(request.getParameter("id"));
		Tutorial existingTutorial = new Tutorial(0, "", "");

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword,classname);
		// Step 2: Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TUTORIAL_BY_ID);) {
			preparedStatement.setInt(1, id);
			if(id>0) {
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();
				// Step 4: Process the ResultSet object 
				while (rs.next()) {
					String title = rs.getString("title");
					String content = rs.getString("content");
					existingTutorial = new Tutorial(id, title, content);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
		//Step 5: Set existingUser to request and serve up the tutorialEdit form
		request.setAttribute("tutorial", existingTutorial);
		request.getRequestDispatcher("/tutorialEdit.jsp").forward(request, response);
	}
		 
	// create tutorial form		 
	private void createTutorial(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		 request.getRequestDispatcher("/createtutorial.jsp").forward(request, response);
	}
		 
	protected boolean createTutorials(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		String contextPath = request.getContextPath();
		//Step 2: Retrieve the two parameters from the request from the web form
		HttpSession session = request.getSession();
		String userRole = (String) session.getAttribute("role");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(userRole != null && ifAdmin(userRole)) {	
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
				response.sendRedirect("dashboard");
				//Step 7: Check if the query had been successfully execute, return “You have successfully created a tutorial!” via the response
				return true;
			}
			//Step 8: catch and print out any exception
			catch (Exception exception) {
				System.out.println(exception);
				return false;
			}
		}response.sendRedirect(contextPath + "/UserServlet/loginPage");
		return false;	
	}

	//UPDATE
	//method to update the tutorial table base on the form data
	protected boolean updateTutorial(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		String userRole = (String) session.getAttribute("role");
		//Step 1: Retrieve value from the request
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(userRole != null && ifAdmin(userRole)) {	
		try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, classname);
				PreparedStatement statement = connection.prepareStatement(UPDATE_TUTORIAL_SQL);) {
					statement.setString(1, title);
					statement.setString(2, content);
					statement.setInt(3, id);
					int i = statement.executeUpdate();
					response.sendRedirect("dashboard");
				return true;
					
				} catch (Exception exception) {
					// TODO Auto-generated catch block
					System.out.println(exception);
					return false;
				}
		}
		response.sendRedirect(contextPath + "/UserServlet/loginPage");
		return false;
	}

	//DELETE
	//method to delete tutorial
	protected boolean deleteTutorial(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		String userRole = (String) session.getAttribute("role");
		//Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));

		if(userRole != null && ifAdmin(userRole)) {	
			//Step 2: Attempt connection with database and execute delete tutorial SQL query
			try (Connection connection = getConnection(jdbcURL, jdbcUsername, jdbcPassword, classname); 
			PreparedStatement statement = connection.prepareStatement(DELETE_TUTORIAL_SQL);) {
				statement.setInt(1, id);
				int i = statement.executeUpdate();
				response.sendRedirect("dashboard");
				return true;
			}catch (Exception exception) {
				// TODO Auto-generated catch block
				System.out.println(exception);
				return false;
			}
		}
		response.sendRedirect(contextPath + "/UserServlet/loginPage");
		return false;
	}
	
	protected boolean ifAdmin(String role) {
		if (role.equals("Admin")) {
			return true;
		}
		else {
			return false;
		}
	}

}