

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		//Step 2: retrieve the two parameters from the request from the web form
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		//Step 3: attempt connection to database using JDBC, you can change the username and password accordingly using the phpMyAdmin > User Account dashboard
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
			
			PreparedStatement ps1 = con.prepareStatement("select id from user where userName = ? and password = ?;");
			ps1.setString(1, userName);
			ps1.setString(2, password);
			ResultSet rs1 = ps1.executeQuery();
			String idExisting = "";
			while (rs1.next()) {
				idExisting = rs1.getString("id");
			}
			if (isNumeric(idExisting)) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", idExisting);
				//Step 3: redirect back to UserServlet dashboard (note: remember to change the url to your project name)
				response.sendRedirect("http://localhost:8090/SourceMe/UserServlet/edit");
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
