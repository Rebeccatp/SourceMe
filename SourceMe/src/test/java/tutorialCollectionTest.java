import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;

class tutorialCollectionTest {

	
	private Tutorial tutorial;
	private Integer tutorialId;
	private Integer deleteId;
	private Integer errorId;
	private String t1;
	private String t2;
	private String t3;
	private String c1;
	private String c2;
	private String c3;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private String usernameerr;
	private String passworderr;
	private Integer setId;

	private String classname;
	private String classnameErr;
//	Tutorial connect = Mockito.mock(Tutorial.class);
//	private Connection connection;
	
	
	@BeforeEach
	void setUp() throws Exception {
		tutorial = new Tutorial(0, null,null);
		tutorialId = 4;
		deleteId = 32;
		errorId = null;
		setId = 1;
		t1 = "T1";
		t2 = "T2";
		t3 = "T3";
		c1 = "C1";
		c2 = "C2";
		c3 = "C3";
		jdbcURL = "jdbc:mysql://localhost:3306/sourceMe";
		jdbcUsername = "root";
		jdbcPassword = "password";
		usernameerr = "username";
		passworderr = "testing";
		classname = "com.mysql.jdbc.Driver";
		classnameErr= "tetsing";
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	

	@Test
	void testGetConnection() {
		var connection = tutorial.getConnection(jdbcURL, jdbcUsername, jdbcPassword,classname);
		assertNotNull(connection);
		var connectionError = tutorial.getConnection(jdbcURL, usernameerr, passworderr,classname);
		assertNull(connectionError);
		var connectionError2 = tutorial.getConnection(jdbcURL, jdbcUsername, jdbcPassword, classnameErr);
		assertNull(connectionError2);
	}
	

	@Test
	void testGetAllTutorials() {
		//Act
		List<Tutorial> testTc = tutorial.getAllTutorials();
		//Assert
		assertFalse(testTc.isEmpty());
		
//		Mockito.doReturn(connection).when(connect).getConnection(jdbcURL, jdbcUsername, jdbcPassword, classname);
//		List<Tutorial>  testTc =connect.getAllTutorials();
//		assertFalse(testTc.isEmpty());
//		Mockito.when(connect.getConnection(jdbcURL, jdbcUsername, jdbcPassword, classname)).thenReturn(connection);
		
	}

	@Test
	void testGetTutorialById() {
		//Act
		var tutorialById = tutorial.getTutorialById(tutorialId);
		//Assert
		assertNotNull(tutorialById);
		var tutorialBy0 = tutorial.getTutorialById(0);
		//Assert
		assertNull(tutorialBy0);
	}

	@Test
	void testCreateTutorial() {
		//	Assert the number of tutorials
		List<Tutorial> testTc = tutorial.getAllTutorials();
		assertFalse(testTc.isEmpty());
		int beforeCreate = testTc.size();
		// Act
		tutorial.createTutorial(t1, c1);
		// Assert
		assertEquals(tutorial.getAllTutorials().size(), beforeCreate +1);
		var createError = tutorial.createTutorial(null, null);
		assertFalse(createError);
	}

	@Test
	void testUpdateTutorialById() {
		//pass call update (parameter1)
		var tutorialById = tutorial.getTutorialById(tutorialId);
		tutorial.updateTutorialById(tutorialId, t3, c3);
		
		// call retrieve record to check para
		assertNotSame(tutorialById,tutorial.getTutorialById(tutorialId));
		var updateError = tutorial.updateTutorialById(errorId, t2, c1);
		assertFalse(updateError);
	}

	@Test
	void testDeleteTutorialById() {
		List<Tutorial> testTc = tutorial.getAllTutorials();
		assertFalse(testTc.isEmpty());
		int beforeDelete = testTc.size();
		var tutorialById = tutorial.getTutorialById(deleteId);
		
		//delete tutorial
		var deletedTutorial = tutorial.deleteTutorialById(deleteId);
		
		// Check size before and after delete
		assertEquals(tutorial.getAllTutorials().size(), beforeDelete-1);
		
		assertTrue(deletedTutorial);
		// Check deleted tutorial
		assertNotSame(tutorialById,tutorial.getTutorialById(deleteId));
		var deleteerror = tutorial.deleteTutorialById(errorId);
		assertFalse(deleteerror);
	}
	
	@Test
	void testgetId() {
		var tutorialById = tutorial.getTutorialById(tutorialId);
		assertNotNull(tutorialById.getId());
	}
	
	@Test
	void testgetTitle() {
		var tutorialById = tutorial.getTutorialById(tutorialId);
		assertNotNull(tutorialById.getTitle());
	}
	@Test
	void testgetContent() {
		var tutorialById = tutorial.getTutorialById(tutorialId);
		assertNotNull(tutorialById.getContent());
	}
	
	@Test
	void testsetId() {
		var tutorialById = tutorial.getTutorialById(tutorialId);
		tutorialById.setId(setId);
		assertEquals(tutorialById.getId(), setId);
	}
	
	@Test
	void testsetTitle() {
		var tutorialById = tutorial.getTutorialById(tutorialId);
		tutorialById.setTitle(t3);
		assertSame(tutorialById.getTitle(), t3);
	}
	@Test
	void testsetContent() {
		var tutorialById = tutorial.getTutorialById(tutorialId);
		tutorialById.setContent(c3);
		assertSame(tutorialById.getContent(), c3);
	}

	
}
