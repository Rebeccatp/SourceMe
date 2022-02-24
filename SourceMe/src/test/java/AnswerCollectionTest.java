//import static org.junit.jupiter.api.Assertions.*;
//import static org.testng.Assert.assertFalse;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//
//class AnswerCollectionTest {
//
//	private Answer answer;
//	private int updateId;
//	private int deleteId;
//	private int deleteId2;
//	private String postBy;
//	private String answers;
//	private Integer answerId;
//	private Integer questionId;
//	private String editAnswers;
//	private String jdbcURL;
//	private String jdbcUsername;
//	private String jdbcPassword;
//	private String jdbcDriver;
//	private String driverErr;
//	private String usernameErr;
//	private String passwordErr;
//	private Connection connection;
//	private Connection connectionError;
//	private Connection connectionError2;
//	private Connection connectionError3;
//	private Question question;
//	private Answer currentAnswer;
//	private boolean createError;
//	private Question currentQuestion;
//	private List <Answer> answerByQnsId;
//	private boolean editError;
//	private boolean deleteById;
//    
//	@BeforeEach
//	void setUp() throws Exception {
//		answerId = 54;
//		questionId = 5;
//		answer = new Answer(0,0,null,null);
//		updateId = 53;
//		deleteId = 61;
//		postBy = "jaslynylh";
//		answers = "123";
//		jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
//		jdbcUsername = "root";
//		jdbcPassword = "password";
//		jdbcDriver = "com.mysql.jdbc.Driver";
//		usernameErr = "err";
//		passwordErr = "hmm";
//		driverErr = "haha";
//		editAnswers = "edited 123";
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//	
//	@Test
//	void testGetId() {
//		answer.setId(answerId);
//		assertEquals(answerId, answer.getId());
//	}
//	
//	@Test
//	void testGetQnsId() {
//		answer.setQnsId(questionId);
//		assertEquals(questionId, answer.getQnsId());
//	}
//	
//	@Test
//	void testGetPostBy() {
//		answer.setPostBy(postBy);
//		assertEquals(postBy, answer.getPostBy());
//	}
//	
//	@Test
//	void testGetAnswers() {
//		answer.setAnswers(answers);
//		assertEquals(answers, answer.getAnswers());
//	}
//	
//	@Test
//	void testGetConnection() {
//		connection = answer.getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
//		assertNotNull(connection);
//		connectionError = answer.getConnection(jdbcURL, usernameErr, passwordErr, jdbcDriver);
//		assertNull(connectionError);
//		connectionError2 = answer.getConnection(jdbcURL, usernameErr, passwordErr, driverErr);
//		assertNull(connectionError2);
//	}
//
//	@Test
//	void testGetAnswerByQnsId(){
//		List <Answer> answerList = answer.getAnswerByQnsId(questionId);
//		//if the answerList is not empty it will be true
//		assertFalse(answerList.isEmpty());
//		connectionError3 = answer.getConnection(jdbcURL, usernameErr, passwordErr, driverErr);
//		assertNull(connectionError3);
//		} 
//
//	@Test
//	void testShowCreateAnswerForm() {
////		fail("Not yet implemented");
//		question = answer.showCreateAnswerForm(questionId);
//		//if the question is not equals to null it will be true
//		assertFalse(question.equals(null));
//	}
//	
//	@Test
//	void testShowEditForm() {
////		fail("Not yet implemented");
//		currentAnswer = answer.showEditForm(updateId);
//		//if the currentAnswer is not equals to null it will be true
//		assertFalse(currentAnswer.equals(null));
//	}
//	
//	@Test
//	void testCreateAnswer(){
////		fail("Not yet implemented");
//			List<Answer> answerList = answer.getAnswerByQnsId(questionId);
//			assertFalse(answerList.isEmpty());
//			answer.createAnswer(0, questionId, postBy, answers);
//			assertEquals(answer.getAnswerByQnsId(questionId).size(), answerList.size()+1);
//			createError = answer.createAnswer(0, null, postBy, answers);
//			assertFalse(createError);
//		}
//
//	@Test
//	void testGetQuestionById() {
////		fail("Not yet implemented");
//		currentQuestion = answer.getQuestionById(questionId);
//		//if the currentQuestion is not equals to null it will be true
//		assertFalse(currentQuestion.equals(null));
//	}
//
//	@Test
//	void testEditAnswer() {
//		answerByQnsId = answer.getAnswerByQnsId(questionId);
//		answer.editAnswer(questionId, postBy, editAnswers, updateId);
//		assertFalse(answerByQnsId.equals(answer.getAnswerByQnsId(questionId)));
//		editError = answer.editAnswer(null, postBy, editAnswers, updateId);
//		assertFalse(editError);
//	}
//
//	@Test
//	void testDeleteAnswer() {
//		deleteById = answer.deleteAnswer(deleteId);
//		assertTrue(deleteById);
//	}
//
//}
