import java.io.IOException;
import java.io.PrintWriter;
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
	private Tutorial tutorial = new Tutorial(0, null,null);

	
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
		tutorials = tutorial.getAllTutorials();
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
		existingTutorial = tutorial.getTutorialById(id);
		System.out.println(existingTutorial.id);
		//Step 5: Set existingUser to request and serve up the tutorialEdit form
		request.setAttribute("tutorial", existingTutorial);
		request.getRequestDispatcher("/tutorialEdit.jsp").forward(request, response);
	}
		 
	// create tutorial form		 
	private void createTutorial(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		 request.getRequestDispatcher("/createtutorial.jsp").forward(request, response);
	}
		 
	protected void createTutorials(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		String contextPath = request.getContextPath();
		//Step 2: Retrieve the two parameters from the request from the web form
		HttpSession session = request.getSession();
		String userRole = (String) session.getAttribute("role");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if (tutorial.createTutorial(title, content, userRole) == true) {
			response.sendRedirect("dashboard");
		}else {
			response.sendRedirect(contextPath + "/UserServlet/loginPage");
		}
	
	}

	//UPDATE
	//method to update the tutorial table base on the form data
	protected void updateTutorial(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		String userRole = (String) session.getAttribute("role");
		//Step 1: Retrieve value from the request
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		//Step 3: redirect back to tutorialServlet
		if (tutorial.updateTutorialById(id, title, content,userRole) == true) {
			response.sendRedirect("dashboard");
		}else {
			response.sendRedirect(contextPath + "/UserServlet/loginPage");
		}
	}

	//DELETE
	//method to delete tutorial
	protected void deleteTutorial(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		String userRole = (String) session.getAttribute("role");
		//Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));

		//Step 3: redirect back to tutorialServlet dashboard
		if (tutorial.deleteTutorialById(id, userRole) == true) {
			response.sendRedirect("dashboard");
		}else {
			response.sendRedirect(contextPath + "/UserServlet/loginPage");
		}
	}
}