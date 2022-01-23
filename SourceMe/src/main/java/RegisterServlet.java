//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
			
			PreparedStatement ps1 = con.prepareStatement("select id from user where userName = ?;");
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
					//Step 7: check if the query had been successfully executed, return “You are successfully registered” via the response,
					if (i2 > 0) {
						PrintWriter writer = response.getWriter();
						writer.println("<h1>" + "You have successfully registered an account!" + "</h1>");
						writer.close();
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
		doGet(request, response);
	}
	
	public static boolean isNumeric(String idString) {
	    int idInt;
	    try {
	    	idInt = Integer.parseInt(idString);
	        return true;
	    } catch (NumberFormatException e) {
	    }
	    return false;
	}

}