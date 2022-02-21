package SourceMe;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class UserSeleniumTest {
	
	// permanent user that is never modified
	private String existingUsername1;
	private String existingPassword1;
	
	// user to be updated
	private String existingRole2;
	private String existingFirstname2;
	private String existingLastname2;
	private String existingNumber2;
	private String existingUsername2;
	private String existingPassword2;
	private String existingEmail2;
	
	// user to be deleted
	private String existingUsername3;
	private String existingPassword3;
	
	// registration details
	private String registerRole;
	private String registerFirstname;
	private String registerLastname;
	private String registerNumber;
	private String registerUsername;
	private String registerPassword;
	private String registerEmail;
	
	// username and password that do not exist in database
	private String wrongUsername;
	private String wrongPassword;
	
	// update details
	private String updateRole;
	private String updateFirstname;
	private String updateLastname;
	private String updateNumber;
	private String updatePassword;
	private String updateEmail;
	
  @Test
  public void navigateToRegisterPage() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
// NAVIGATE TO REGISTER PAGE FROM HOME PAGE
	  driver.get("http://localhost:8090/SourceMe/home");
	  driver.findElement(By.linkText("Sign Up")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
	  
// NAVIGATE TO REGISTER PAGE FROM LOGIN PAGE	  
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.linkText("click here")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
  }
  
  @Test
  public void navigateToLoginPage() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
// NAVIGATE TO LOGIN PAGE FROM HOME PAGE
	  driver.get("http://localhost:8090/SourceMe/home");
	  driver.findElement(By.linkText("Sign In")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
	  
// NAVIGATE TO LOGIN PAGE FROM REGISTER PAGE	  
	  driver.get("http://localhost:8090/SourceMe/UserServlet/registerPage");
	  driver.findElement(By.linkText("Login")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
  }
  
  @Test
  public void register() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
// REGISTER FAIL (USERNAME ALREADY EXISTS)
	  driver.get("http://localhost:8090/SourceMe/UserServlet/registerPage");
	  
	  // fill in registration form
	  Select registerRole1 = new Select(driver.findElement(By.id("registerRole")));
	  registerRole1.selectByVisibleText(registerRole);
	  driver.findElement(By.id("registerFirstname")).sendKeys(registerFirstname);
	  driver.findElement(By.id("registerLastname")).sendKeys(registerLastname);
	  driver.findElement(By.id("registerNumber")).sendKeys(registerNumber);
	  driver.findElement(By.id("registerUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("registerPassword")).sendKeys(registerPassword);
	  driver.findElement(By.id("registerEmail")).sendKeys(registerEmail);
	  
	  // submit registration form
	  driver.findElement(By.id("registerBtn")).click();
	  
	  // check if navigated to "register"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/register", driver.getCurrentUrl());
	  
	  // check for error message
	  driver.findElements(By.xpath("//*[contains(text(), 'Username already exists!')]"));
	  
// REGISTER SUCCESS
	  driver.get("http://localhost:8090/SourceMe/UserServlet/registerPage");
	  
	  // fill in registration form
	  Select registerRole2 = new Select(driver.findElement(By.id("registerRole")));
	  registerRole2.selectByVisibleText(registerRole);
	  driver.findElement(By.id("registerFirstname")).sendKeys(registerFirstname);
	  driver.findElement(By.id("registerLastname")).sendKeys(registerLastname);
	  driver.findElement(By.id("registerNumber")).sendKeys(registerNumber);
	  driver.findElement(By.id("registerUsername")).sendKeys(registerUsername);
	  driver.findElement(By.id("registerPassword")).sendKeys(registerPassword);
	  driver.findElement(By.id("registerEmail")).sendKeys(registerEmail);
	  
	  // submit registration form
	  driver.findElement(By.id("registerBtn")).click();
	  
	  // check if navigated to "loginPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
  }
  
  @Test
  public void login() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
// LOGIN FAIL (WRONG USERNAME)
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  
	  // fill in login form
	  driver.findElement(By.id("loginUsername")).sendKeys(wrongUsername);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword1);
	  
	  // submit login form
	  driver.findElement(By.id("loginBtn")).click();
	  
	  // check if navigated to "login"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
	  
	  // check for error message
	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
	  
// LOGIN FAIL (WRONG PASSWORD)
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("loginPassword")).sendKeys(wrongPassword);
	  driver.findElement(By.id("loginBtn")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
	  
// LOGIN FAIL (WRONG USERNAME AND PASSWORD)
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(wrongUsername);
	  driver.findElement(By.id("loginPassword")).sendKeys(wrongPassword);
	  driver.findElement(By.id("loginBtn")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
	  
// LOGIN SUCCESS
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword1);
	  driver.findElement(By.id("loginBtn")).click();
	  
	  // check if navigated to "edit"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
  }
  
  @Test
  public void navigateToHomePage() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
// NAVIGATE TO HOME PAGE FROM LOGIN PAGE
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.linkText("Home")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/home", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
	  
// NAVIGATE TO HOME PAGE FROM REGISTER PAGE
	  driver.get("http://localhost:8090/SourceMe/UserServlet/registerPage");
	  driver.findElement(By.linkText("Home")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/home", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
	  
// NAVIGATE TO HOME PAGE FROM PROFILE PAGE
	  // login
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword1);
	  driver.findElement(By.id("loginBtn")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
	  //navigate to "home"
	  driver.findElement(By.linkText("Home")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/home", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: profile & logout; invisible: login & register
	  driver.findElement(By.linkText(existingUsername1));
	  driver.findElement(By.id("logoutBtn"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='signinNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='signupNav']")).size() == 0);
  }
  
  @Test
  public void navigateToProfilePage() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();

// NAVIGATE TO PROFILE PAGE VIA URL	  
// ACCESS DENIED (NOT LOGGED IN)
	  driver.get("http://localhost:8090/SourceMe/UserServlet/edit");
	  // check if redirected to "loginPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
	  
// NAVIGATE TO PROFILE PAGE FROM HOME PAGE
	  // login
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword1);
	  driver.findElement(By.id("loginBtn")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
	  driver.get("http://localhost:8090/SourceMe/home");
	  //navigate to "edit"
	  driver.findElement(By.linkText(existingUsername1)).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: profile & logout; invisible: login & register
	  driver.findElement(By.linkText(existingUsername1));
	  driver.findElement(By.id("logoutBtn"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='signinNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='signupNav']")).size() == 0);
  }
  
  @Test
  public void update() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
// UPDATE SUCCESS
	  // login
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername2);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword2);
	  driver.findElement(By.id("loginBtn")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
	  // check if profile form is pre-populated
	  String role = driver.findElement(By.id("updateRole")).getAttribute("value");
	  String firstname = driver.findElement(By.id("updateFirstname")).getAttribute("value");
	  String lastname = driver.findElement(By.id("updateLastname")).getAttribute("value");
	  String number = driver.findElement(By.id("updateNumber")).getAttribute("value");
	  String username = driver.findElement(By.id("username")).getAttribute("value");
	  String password = driver.findElement(By.id("updatePassword")).getAttribute("value");
	  String email = driver.findElement(By.id("updateEmail")).getAttribute("value");
	  Assert.assertTrue(role.equals(existingRole2));
	  Assert.assertTrue(firstname.equals(existingFirstname2));
	  Assert.assertTrue(lastname.equals(existingLastname2));
	  Assert.assertTrue(number.equals(existingNumber2));
	  Assert.assertTrue(username.equals(existingUsername2));
	  Assert.assertTrue(password.equals(existingPassword2));
	  Assert.assertTrue(email.equals(existingEmail2));
	  
	  // fill in profile form
	  driver.findElement(By.id("updateFirstname")).clear();
	  driver.findElement(By.id("updateLastname")).clear();
	  driver.findElement(By.id("updateNumber")).clear();
	  driver.findElement(By.id("updatePassword")).clear();
	  driver.findElement(By.id("updateEmail")).clear();
	  Select updateRole1 = new Select(driver.findElement(By.id("updateRole")));
	  updateRole1.selectByVisibleText(updateRole);
	  driver.findElement(By.id("updateFirstname")).sendKeys(updateFirstname);
	  driver.findElement(By.id("updateLastname")).sendKeys(updateLastname);
	  driver.findElement(By.id("updateNumber")).sendKeys(updateNumber);
	  driver.findElement(By.id("updatePassword")).sendKeys(updatePassword);
	  driver.findElement(By.id("updateEmail")).sendKeys(updateEmail);
	  
	  // submit profile form
	  driver.findElement(By.id("updateBtn")).click();
	  
	  // check if profile form is updated with new details after page refresh
	  role = driver.findElement(By.id("updateRole")).getAttribute("value");
	  firstname = driver.findElement(By.id("updateFirstname")).getAttribute("value");
	  lastname = driver.findElement(By.id("updateLastname")).getAttribute("value");
	  number = driver.findElement(By.id("updateNumber")).getAttribute("value");
	  username = driver.findElement(By.id("username")).getAttribute("value");
	  password = driver.findElement(By.id("updatePassword")).getAttribute("value");
	  email = driver.findElement(By.id("updateEmail")).getAttribute("value");
	  Assert.assertTrue(role.equals(updateRole));
	  Assert.assertTrue(firstname.equals(updateFirstname));
	  Assert.assertTrue(lastname.equals(updateLastname));
	  Assert.assertTrue(number.equals(updateNumber));
	  Assert.assertTrue(username.equals(existingUsername2));
	  Assert.assertTrue(password.equals(updatePassword));
	  Assert.assertTrue(email.equals(updateEmail));
  }
  
  @Test
  public void logout() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
// LOGOUT FROM HOME PAGE
	  // login
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword1);
	  driver.findElement(By.id("loginBtn")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
	  driver.get("http://localhost:8090/SourceMe/home");
	  
	  // click on logout nav link
	  driver.findElement(By.id("logoutBtn")).click();
	  
	  // check if navigated to "loginPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
	  
// LOGOUT FROM PROFILE PAGE
	  // login
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword1);
	  driver.findElement(By.id("loginBtn")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
	  driver.get("http://localhost:8090/SourceMe/UserServlet/edit");
	  
	  // click on logout nav link
	  driver.findElement(By.id("logoutBtn")).click();
	  
	  // check if navigated to "loginPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
  }
  
  @Test
  public void delete() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
// DELETE SUCCESS
	  // login
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername3);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword3);
	  driver.findElement(By.id("loginBtn")).click();
	  Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8090/SourceMe/UserServlet/edit");
	  
	  // click on delete account button
	  driver.findElement(By.id("deleteBtn")).click();
	  
	  // check if navigated to "registerPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
	  
	  // check navbar items
	  // visible: login & register; invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
  }
  
  @BeforeTest
  public void beforeTest() {
	  existingUsername1 = "jane";
	  existingPassword1 = "password";
	  
	  existingRole2 = "User";
	  existingFirstname2 = "John";
	  existingLastname2 = "Doe";
	  existingNumber2 = "12345678";
	  existingUsername2 = "john";
	  existingPassword2 = "password";
	  existingEmail2 = "john@email.com";
	  
	  existingUsername3 = "james";
	  existingPassword3 = "password";
	  
	  registerRole = "User";
	  registerFirstname = "Mickey";
	  registerLastname = "Mouse";
	  registerNumber = "12345678";
	  registerUsername = "mickey";
	  registerPassword = "qwerty123";
	  registerEmail = "mickey@email.com";
	  
	  wrongUsername = "winnie";
	  wrongPassword = "pooh";
	  
	  updateRole = "Admin";
	  updateFirstname = "Donald";
	  updateLastname = "Duck";
	  updateNumber = "87654321";
	  updatePassword = "123qwerty";
	  updateEmail = "donald@email.com";
  }

  @AfterTest
  public void afterTest() {
  }

}
