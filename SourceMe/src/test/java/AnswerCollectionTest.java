import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertFalse;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AnswerCollectionTest {

	private Answer answer;
	private int updateId;
	private int deleteId;
	private int deleteId2;
	private String postBy;
	private String answers;
	private Integer answerId;
	private Integer questionId;
	private String editAnswers;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private String jdbcDriver;
	private String driverErr;
	private String usernameErr;
	private String passwordErr;
    
	@BeforeEach
	void setUp() throws Exception {
		answerId = 1;
		questionId = 5;
		answer = new Answer(0,0,null,null);
		updateId = 84;
		deleteId = 209;
		deleteId2 = 0;
		postBy = "jaslynylh";
		answers = "123";
		jdbcURL = "jdbc:mysql://localhost:3306/sourceme";
		jdbcUsername = "root";
		jdbcPassword = "password";
		jdbcDriver = "com.mysql.jdbc.Driver";
		usernameErr = "err";
		passwordErr = "hmm";
		driverErr = "haha";
		editAnswers = "edited 123";
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testGetId() {
		answer.setId(answerId);
		assertEquals(answerId, answer.getId());
	}
	
	@Test
	void testGetQnsId() {
		answer.setQnsId(questionId);
		assertEquals(questionId, answer.getQnsId());
	}
	
	@Test
	void testGetPostBy() {
		answer.setPostBy(postBy);
		assertEquals(postBy, answer.getPostBy());
	}
	
	@Test
	void testGetAnswers() {
		answer.setAnswers(answers);
		assertEquals(answers, answer.getAnswers());
	}
	
	@Test
	void testGetConnection() {
		var connection = answer.getConnection(jdbcURL, jdbcUsername, jdbcPassword, jdbcDriver);
		assertNotNull(connection);
		var connectionError = answer.getConnection(jdbcURL, usernameErr, passwordErr, jdbcDriver);
		assertNull(connectionError);
		var connectionError2 = answer.getConnection(jdbcURL, usernameErr, passwordErr, driverErr);
		assertNull(connectionError2);
	}

	@Test
	void testGetAnswerByQnsId(){
		List <Answer> answerList = answer.getAnswerByQnsId(questionId);
		//if the answerList is not empty it will be true
		assertFalse(answerList.isEmpty());
		var connectionError3 = answer.getConnection(jdbcURL, usernameErr, passwordErr, driverErr);
		assertNull(connectionError3);
		} 

	@Test
	void testShowCreateAnswerForm() {
//		fail("Not yet implemented");
		var question = answer.showCreateAnswerForm(questionId);
		//if the question is not equals to null it will be true
		assertFalse(question.equals(null));
	}
	
	@Test
	void testShowEditForm() {
//		fail("Not yet implemented");
		var currentAnswer = answer.showEditForm(updateId);
		//if the currentAnswer is not equals to null it will be true
		assertFalse(currentAnswer.equals(null));
	}
	
	@Test
	void testCreateAnswer(){
//		fail("Not yet implemented");
			List<Answer> answerList = answer.getAnswerByQnsId(questionId);
			assertFalse(answerList.isEmpty());
			answer.createAnswer(0, questionId, postBy, answers);
			assertEquals(answer.getAnswerByQnsId(questionId).size(), answerList.size()+1);
			var createError = answer.createAnswer(0, null, postBy, answers);
			assertFalse(createError);
		}

	@Test
	void testGetQuestionById() {
//		fail("Not yet implemented");
		var currentQuestion = answer.getQuestionById(questionId);
		//if the currentQuestion is not equals to null it will be true
		assertFalse(currentQuestion.equals(null));
	}

	@Test
	void testEditAnswer() {
		var answerByQnsId = answer.getAnswerByQnsId(questionId);
		answer.editAnswer(questionId, postBy, editAnswers, updateId);
		assertFalse(answerByQnsId.equals(answer.getAnswerByQnsId(questionId)));
		var editError = answer.editAnswer(null, postBy, editAnswers, updateId);
		assertFalse(editError);
	}

	@Test
	void testDeleteAnswer() {
		List<Answer> answerList = answer.getAnswerByQnsId(questionId);
		assertFalse(answerList.isEmpty());
		var deleteById = answer.deleteAnswer(deleteId);
		assertEquals(answer.getAnswerByQnsId(questionId).size(), answerList.size()-1);
	}

}
