import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class addQuestionServlet
 */
@WebServlet("/addQuestionServlet")
public class addQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addQuestionServlet() {
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
		response.setContentType("text/html");
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		//Step 2: Retrieve the three parameters from the request from the web form
		String t = request.getParameter("title");
		String q = request.getParameter("question");
		String u = request.getParameter("username");
		//Step 3: attempt connection to database using JDBC
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/sourceme", "root", "password");
			//Step 4: Implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into question values(?,?,?,?)");
			//Step 5: Parse in the data retrieved from the web form request into the prepared statement accordingly
			ps.setInt(1, 0);
			ps.setString(2, t);
			ps.setString(3, q);
			ps.setString(4, u);
			//Step 6: Perform the query on the database using the prepared statement
			int i = ps.executeUpdate();
			//Step 7: Check if the query had been successfully executed, return Question added via the response
			if (i > 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "Question added!" + "</h1>");
				writer.close(); 
			} 
		}
		//Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
		doGet(request, response);
	}

}
