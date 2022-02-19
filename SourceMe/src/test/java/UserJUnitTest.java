import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Console;

/**
 * 
 */

/**
 * @author akjza
 *
 */
class UserJUnitTest {
	
	private UserCollection uc;
	
	// create user
	private String createRole;
	private String createFirstname;
	private String createLastname;
	private String createNumber;
	private String createUsername;
	private String createPassword;
	private String createEmail;
	
	// get user by id
	private User existingUser;
	
	// update user by id
	private String updateId;
	private String updateRole;
	private String updateFirstname;
	private String updateLastname;
	private String updateNumber;
	private String updatePassword;
	private String updateEmail;
	
	// delete user by id
	private String existingId;
	
	// login
	private String wrongUsername;
	private String wrongPassword;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		uc = new UserCollection();
		
		// create user
		createRole = "Admin";
		createFirstname = "Twilight";
		createLastname = "Sparkle";
		createNumber = "12345678";
		createUsername = "twilight";
		createPassword = "qwerty123";
		createEmail = "twilight@email.com";
		
		// get user by id
		existingUser = new User(16, "Admin", "Jane", "Doe", "12345678", "admin1", "password", "admin1@email.com");
		
		// update user by id
		updateId = "48";
		updateRole = "User";
		updateFirstname = "Rainbow";
		updateLastname = "Dash";
		updateNumber = "87654321";
		updatePassword = "123qwerty";
		updateEmail = "rainbow@email.com";
		
		// delete user by id
		existingId = "1";
		
		// login
		wrongUsername = "winnie";
		wrongPassword = "pooh";
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link User#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testCreateUser() {
// CREATE USER FAIL (USERNAME ALREADY EXISTS)
		String result1 = uc.createUser(createRole, createFirstname, createLastname, createNumber, existingUser.userName, createPassword, createEmail);
		assertTrue(result1.equals("username already exists"));
		
// CREATE USER SUCCESS
		String result2 = uc.createUser(createRole, createFirstname, createLastname, createNumber, createUsername, createPassword, createEmail);
		assertTrue(result2.equals("success"));
	}

	/**
	 * Test method for {@link User#getUserById(java.lang.String)}.
	 */
	@Test
	void testGetUserById() {
// GET USER SUCCESS
		User result = uc.getUserById(String.valueOf(existingUser.id));
		assertTrue(result.id == existingUser.id);
		assertTrue(result.role.equals(existingUser.role));
		assertTrue(result.firstName.equals(existingUser.firstName));
		assertTrue(result.lastName.equals(existingUser.lastName));
		assertTrue(result.number.equals(existingUser.number));
		assertTrue(result.password.equals(existingUser.password));
		assertTrue(result.email.equals(existingUser.email));
		
	}

	/**
	 * Test method for {@link User#updateUserById(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testUpdateUserById() {
// UPDATE USER SUCCESS
		boolean result = uc.updateUserById(updateId, updateRole, updateFirstname, updateLastname, updateNumber, updatePassword, updateEmail);
		assertTrue(result);
	}

	/**
	 * Test method for {@link User#deleteUserById(java.lang.String)}.
	 */
	@Test
	void testDeleteUserById() {
// DELETE USER SUCCESS
		boolean result = uc.deleteUserById(existingId);
		assertTrue(result);
	}

	/**
	 * Test method for {@link User#login(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testLogin() {
// LOGIN FAIL (WRONG USERNAME)
		String result1 = uc.login(wrongUsername, existingUser.password);
		assertTrue(result1.equals("wrong username or password"));
		
// LOGIN FAIL (WRONG PASSWORD)
		String result2 = uc.login(existingUser.userName, wrongPassword);
		assertTrue(result2.equals("wrong username or password"));
		
// LOGIN FAIL (WRONG USERNAME AND PASSWORD)
		String result3 = uc.login(wrongUsername, wrongPassword);
		assertTrue(result3.equals("wrong username or password"));
		
// LOGIN SUCCESS
		String result4 = uc.login(existingUser.userName, existingUser.password);
		assertTrue(result4.equals(String.valueOf(existingUser.id)));
	}

}
