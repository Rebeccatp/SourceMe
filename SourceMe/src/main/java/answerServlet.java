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
	
    //Step 1: Prepare list of variables used for database connections
    private String jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    //Step 2: Prepare list of SQL prepared statements to perform CRUD to database
    private static final String SELECT_QUESTION_BY_ID = "select title, question, username from question where id = ?";
    private static final String SELECT_ALL_ANSWERS = "select * from answers";
    private static final String SELECT_ANSWER_BY_ID = "select id, qnsId, postBy, answers from answers where id = ?";
    private static final String UPDATE_ANSWER_SQL = "update answers set qnsId = ?, postBy = ?, answers = ? where id = ?";
    private static final String DELETE_ANSWER_SQL = "delete from answers where id = ?";

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
		try (Connection connection = getConnection();
		        //Step 2: Create statements using connection object
		        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTION_BY_ID);
		        PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_ALL_ANSWERS);) {
		        preparedStatement.setInt(1, id);
		            //Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();
		            ResultSet rs2 = preparedStatement2.executeQuery();
		            //Step 4: Process the ResultSet object
		            while (rs.next()) {
		             String title = rs.getString("title");
		             String question = rs.getString("question");
		             String username = rs.getString("username");
		             existingQuestion = new Question(id, title, question, username);
		            }
		            while (rs2.next()) {
		                int ansId = rs2.getInt("id");
		                int qnsId = rs2.getInt("qnsId");
		                String postBy = rs2.getString("postBy");
		                String answer = rs2.getString("answers");
		                answerList.add(new Answer(ansId, qnsId, postBy, answer));
		              }
		          } catch (SQLException e) {
		              System.out.println(e.getMessage());
		          }
		          //Step 5: Set existingQuestion and answerList to request and serve up the viewAnswer form
		          request.setAttribute("question", existingQuestion);
		          request.setAttribute("answerList", answerList);
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
			
			 try (Connection connection = getConnection();
			            //Step 2: Create a statement using connection object
			            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUESTION_BY_ID);) {
			                preparedStatement.setInt(1, qnsId);
			                //Step 3: Execute the query or update query
			                ResultSet rs = preparedStatement.executeQuery();
			                //Step 4: Process the ResultSet object
			                while (rs.next()) {
			                    String title = rs.getString("title");
			                    String question = rs.getString("question");
			                    String username = rs.getString("username");
			                    existingQuestion = new Question(qnsId, title, question, username);
			                }
			            } catch (SQLException e) {
			                System.out.println(e.getMessage());
			            }
			            request.setAttribute("question", existingQuestion);
			            request.getRequestDispatcher("/createAnswer.jsp").forward(request, response);
			        }else {
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
		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
        String idString = (String) session.getAttribute("userId");
        if (ifId(idString)) {
		//Step 3: Attempt connection to database using JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sourceme", "root", "password");
            //Step 4: implement the sql query using prepared statement (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
            PreparedStatement ps = con.prepareStatement("insert into answers values(?,?,?,?)");
            //Step 5: parse in the data retrieved from the web form request into the prepared statement accordingly
            ps.setInt(1, 0);
            ps.setInt(2, qnsId);
            ps.setString(3, postBy);
            ps.setString(4, answers);
            //Step 6: perform the query on the database using the prepared statement
            int i = ps.executeUpdate();
            //Step 7: check if the query had been successfully executed
            if (i > 0) {
                response.sendRedirect("viewAnswer?id=" + qnsId);
            }
        }
        //Step 8: catch and print out any exception
        catch (Exception exception) {
            System.out.println(exception);
            out.close();
		}
        }
	}
	
	protected boolean ifId(String id){
        if (id != null){
        return true;
        }
        else {
            return false;

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