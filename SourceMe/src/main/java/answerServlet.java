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
 * Servlet implementation class createAnswerServlet
 */
@WebServlet("/AnswerServlet")
public class answerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Answer answer = new Answer(0, 0, null, null);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public answerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter();
		//Step 4: Depending on the request servlet path, determine the function to invoke using the following switch statement
		String action = request.getServletPath();
		try {
			switch (action) {
				case "/answerServlet/addAnswer": showCreateAnswerForm(request, response);
				break;
				case "/answerServlet/createAnswer": createAnswer(request, response);
				break;
				case "/answerServlet/viewAnswer": viewAnswer(request, response);
				break;
				case "/answerServlet/editAnswer": showEditForm(request, response); 
				break;
				case "/answerServlet/updateAnswer": updateAnswer(request, response); 
				break;
				case "/answerServlet/deleteAnswer": deleteAnswer(request, response); 
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
		response.setContentType("text/html");
	}
	
   private void viewAnswer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List <Answer> answerList = new ArrayList <>();
		//Get parameter passed in the URL
		int id = Integer.parseInt(request.getParameter("id"));
		Question existingQuestion = new Question(0,"", "", "");
		//Step 5: Set existingQuestion and answerList to request and serve up the viewAnswer form
		answerList = answer.getAnswerByQnsId(id);
		existingQuestion = answer.getQuestionById(id);
		request.setAttribute("question", existingQuestion);
		request.setAttribute("answerList", answerList);
		System.out.println(answerList);
		request.getRequestDispatcher("/viewAnswer.jsp").forward(request, response);
	}
	
	private void showCreateAnswerForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		String idString = (String) session.getAttribute("userId");
		if (idString != null) {
			//Get parameter passed in the URL
			int qnsId = Integer.parseInt(request.getParameter("qnsId"));
			Question existingQuestion = new Question(0,"","","");
			existingQuestion = answer.showCreateAnswerForm(qnsId);
			request.setAttribute("question", existingQuestion);
			request.getRequestDispatcher("/createAnswer.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(contextPath + "/UserServlet/loginPage");
		}
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		//get parameter passed in the URL
		int id = Integer.parseInt(request.getParameter("id"));
		Answer existingAnswer = new Answer(0,0,"","");
		//Step 5: Set existingAnswer to request and serve up the editAnswer form
		existingAnswer = answer.showEditForm(id);
		request.setAttribute("answer", existingAnswer);
		request.getRequestDispatcher("/editAnswer.jsp").forward(request, response);
	}
	
	private void updateAnswer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));
		int qnsId = Integer.parseInt(request.getParameter("qnsId"));
		String postBy = request.getParameter("postBy");
		String answers = request.getParameter("answer");
		if(answer.editAnswer(qnsId, postBy, answers, id) == true) {
			response.sendRedirect("viewAnswer?id=" + qnsId);
		}
	}
	
	private void createAnswer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		//Step 2: Retrieve the three parameters from the request from the web form
		int qnsId = Integer.parseInt(request.getParameter("qnsId"));
		String postBy = request.getParameter("postBy");
		String answers = request.getParameter("answer");
		//Step 3: Attempt connection to database using JDBC
		try {
			if (answer.createAnswer(0, qnsId, postBy, answers) == true) {
				response.sendRedirect("viewAnswer?id=" + qnsId);
			}
		}
		//Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}
	}
	
	private void deleteAnswer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		//Step 1: Retrieve value from the request
		int id = Integer.parseInt(request.getParameter("id"));
		int qnsId = answer.deleteAnswer(id);
		System.out.println(qnsId);
			response.sendRedirect("viewAnswer?id=" + qnsId);
	}
}