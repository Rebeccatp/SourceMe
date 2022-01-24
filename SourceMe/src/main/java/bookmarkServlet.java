

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Import PrintWriter class from Java.io lib
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Servlet implementation class bookmarkServlet
 */
@WebServlet("/bookmarkServlet")
public class bookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookmarkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Step 4: Depending on the request servlet path, determine the function to invoke using the follow switch statement.
				String action = request.getServletPath(); 
				 switch (action) {
				 case "/questionServlet/bookmark":
				 //myBookmark(request, response);
				 break;
				 } 
	}

	/*
	 * private void myBookmark(HttpServletRequest request, HttpServletResponse
	 * response) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 */	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1: retrieve parameter yourName from the request from the web form
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String question = request.getParameter("question");
		String username = request.getParameter("username");
		//Step 2: Initialize a PrintWriter object to return the html values via the response
		PrintWriter writer = response.getWriter();
		writer.println("<h1>" + title + "</h1>");
		writer.println("<h1>" + question + "</h1>");
		writer.println("<h1>" + username + "</h1>");
		writer.close();
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.sendRedirect("http://localhost:8090/SourceMe/Bookmark.jsp");
	}

}
