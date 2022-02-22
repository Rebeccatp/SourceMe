//import static org.junit.jupiter.api.Assertions.*;
//
//import java.sql.Connection;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.verify;
//
//class tutorialCollectionTest {
//
//	
//	private Tutorial tutorial;
//	private Tutorial tutorial2;
//	private TutorialCollection mockTutorialCollection = mock(TutorialCollection.class);
//	
//	private Integer tutorialId;
//	private Integer deleteId;
//	private Integer errorId;
//	private String t1;
//	private String t2;
//	private String t3;
//	private String c1;
//	private String c2;
//	private String c3;
//	private String jdbcURL;
//	private String jdbcUsername;
//	private String jdbcPassword;
//	private String usernameerr;
//	private String passworderr;
//	private Integer setId;
//	private String role;
//	private String classname;
//	private String classnameErr;
//	private Tutorial tutorialById;
//	private Tutorial tutorialBy0;
//	private Connection connection;
//	private Connection connectionError;
//	private Connection connectionError2;
//	
//	@BeforeEach
//	void setUp() throws Exception {
//		tutorial = new Tutorial(0, null,null);
//		tutorial2 = new Tutorial(mockTutorialCollection);
//		tutorialId = 77;
//		deleteId = 62;
//		errorId = null;
//		setId = 64;
//		t1 = "T1";
//		t2 = "T2";
//		t3 = "T3";
//		c1 = "C1";
//		c2 = "C2";
//		c3 = "C3";
//		jdbcURL = "jdbc:mysql://localhost:3306/sourceMe";
//		jdbcUsername = "root";
//		jdbcPassword = "password";
//		usernameerr = "username";
//		passworderr = "testing";
//		classname = "com.mysql.jdbc.Driver";
//		classnameErr= "tetsing";
//		role = "Admin";
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//	
//
//	@Test
//	void testGetConnection() {
//		
//		//Act (Get the correct connection parameters)
//		connection = tutorial.getConnection(jdbcURL, jdbcUsername, jdbcPassword,classname);
//		//Assert
//		assertNotNull(connection);
//		
//		//Act (Get the incorrect username and password (SQLException))
//		connectionError = tutorial.getConnection(jdbcURL, usernameerr, passworderr,classname);
//		//Assert
//		assertNull(connectionError);
//		
//		//Act (Get the incorrect classname (ClassNotFoundException))
//		connectionError2 = tutorial.getConnection(jdbcURL, jdbcUsername, jdbcPassword, classnameErr);
//		//Assert
//		assertNull(connectionError2);
//	}
//	
//
//	@Test
//	void testGetAllTutorials() {
//		
//		//Act (Get all the tutorial)
//		List<Tutorial> testTc = tutorial.getAllTutorials();
//		//Assert
//		assertFalse(testTc.isEmpty());	
//		
//	}
//
//	@Test
//	void testGetTutorialById() {
//		
//		//Act (Get tutorial by id)
//		tutorialById = tutorial.getTutorialById(tutorialId);
//		//Assert (check that is it not null)
//		assertNotNull(tutorialById);
//		
//		//Act (Get Tutorial by id(0))
//		tutorialBy0 = tutorial.getTutorialById(0);
//		//Assert (check that it is null)
//		assertNull(tutorialBy0);
//	}
//
//	@Test
//	void testCreateTutorial() {
//		
//		// Act
//		when(mockTutorialCollection.ifAdmin(role)).thenReturn(true);
//		
//		//Act & Assert (Check if return true value)
//		assertTrue(tutorial2.createTutorial(t1, c1,role));	
//		
//		//check if mocktutorial collection is being used
//		verify(mockTutorialCollection).ifAdmin(role);
//	}
//	
//	@Test
//	void testCreateTutorialError() {		
//		
//		//	Assert the number of tutorials
////		List<Tutorial> testTc = tutorial.getAllTutorials();
////		assertFalse(testTc.isEmpty());
////		int beforeCreate = testTc.size();
//		
//		// Act
//		when(mockTutorialCollection.ifAdmin(role)).thenReturn(true);
//		
//		//Act & Assert (Check if return false value and if the size remain the same )
//		assertFalse(tutorial2.createTutorial(null, null, role));
////		assertEquals(tutorial.getAllTutorials().size(), beforeCreate);
//		verify(mockTutorialCollection).ifAdmin(role);
//		
//		// Act & Assert (Check if return false value with incorrect role)
//		assertFalse(tutorial2.createTutorial(t1, c1, null));
//	}
//
//	@Test
//	void testUpdateTutorialById() {
//		when(mockTutorialCollection.ifAdmin(role)).thenReturn(true);
//		//pass call update (parameter1)
////		var tutorialById = tutorial.getTutorialById(tutorialId);
//		assertTrue(tutorial2.updateTutorialById(tutorialId, t3, c3, role));
//		// call retrieve record to check para
////		assertNotSame(tutorialById,tutorial.getTutorialById(tutorialId));
//		verify(mockTutorialCollection).ifAdmin(role);
//	}
//	
//	@Test
//	void testUpdateTutorialByIdError() {
//		when(mockTutorialCollection.ifAdmin(role)).thenReturn(true);
//		//pass call update (parameter1)
//		// call retrieve record to check para
//		assertFalse(tutorial2.updateTutorialById(errorId, t2, c1,role));
//		verify(mockTutorialCollection).ifAdmin(role);
//		
//		// Act & Assert (Check if return false value with incorrect role)
//		assertFalse(tutorial2.updateTutorialById(tutorialId, t3, c3, null));
//	}
//
//	@Test
//	void testDeleteTutorialById() {
//		when(mockTutorialCollection.ifAdmin(role)).thenReturn(true);
////		List<Tutorial> testTc = tutorial.getAllTutorials();
////		assertFalse(testTc.isEmpty());
////		int beforeDelete = testTc.size();
////		var tutorialById = tutorial.getTutorialById(deleteId);
//		
//		//delete tutorial
//		//var deletedTutorial = tutorial2.deleteTutorialById(deleteId,role);
//		assertTrue(tutorial2.deleteTutorialById(deleteId,role));
//		// Check size before and after delete
////		assertEquals(tutorial.getAllTutorials().size(), beforeDelete-1);
//		
//
//		// Check deleted tutorial
////		assertNotSame(tutorialById,tutorial.getTutorialById(deleteId));
//		verify(mockTutorialCollection).ifAdmin(role);
//	}
//	
//	@Test
//	void testDeleteTutorialByIdError() {
//		when(mockTutorialCollection.ifAdmin(role)).thenReturn(true);
////		List<Tutorial> testTc = tutorial.getAllTutorials();
////		assertFalse(testTc.isEmpty());
////		int beforeDelete = testTc.size();
//		assertFalse(tutorial2.deleteTutorialById(errorId, role));
////		assertEquals(tutorial.getAllTutorials().size(), beforeDelete);
//		verify(mockTutorialCollection).ifAdmin(role);
//		
//		// Act & Assert (Check if return false value with incorrect role)
//		assertFalse(tutorial2.deleteTutorialById(deleteId, null));
//	}
//	
//	@Test
//	void testgetId() {
//		tutorialById = tutorial.getTutorialById(tutorialId);
//		assertNotNull(tutorialById.getId());
//	}
//	
//	@Test
//	void testgetTitle() {
//		tutorialById = tutorial.getTutorialById(tutorialId);
//		assertNotNull(tutorialById.getTitle());
//	}
//	@Test
//	void testgetContent() {
//		tutorialById = tutorial.getTutorialById(tutorialId);
//		assertNotNull(tutorialById.getContent());
//	}
//	
//	@Test
//	void testsetId() {
//		tutorialById = tutorial.getTutorialById(tutorialId);
//		tutorialById.setId(setId);
//		assertEquals(tutorialById.getId(), setId);
//	}
//	
//	@Test
//	void testsetTitle() {
//		tutorialById = tutorial.getTutorialById(tutorialId);
//		tutorialById.setTitle(t3);
//		assertSame(tutorialById.getTitle(), t3);
//	}
//	@Test
//	void testsetContent() {
//		tutorialById = tutorial.getTutorialById(tutorialId);
//		tutorialById.setContent(c3);
//		assertSame(tutorialById.getContent(), c3);
//	}
//
//	
//}
