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
	
	private String existingRole1;
	private String existingFirstname1;
	private String existingLastname1;
	private String existingNumber1;
	private String existingUsername1;
	private String existingPassword1;
	private String existingEmail1;
	
	private String existingRole2;
	private String existingFirstname2;
	private String existingLastname2;
	private String existingNumber2;
	private String existingUsername2;
	private String existingPassword2;
	private String existingEmail2;
	
	private String existingRole3;
	private String existingFirstname3;
	private String existingLastname3;
	private String existingNumber3;
	private String existingUsername3;
	private String existingPassword3;
	private String existingEmail3;
	
	private String registerRole;
	private String registerFirstname;
	private String registerLastname;
	private String registerNumber;
	private String registerUsername;
	private String registerPassword;
	private String registerEmail;
	
	private String wrongUsername;
	private String wrongPassword;
	
	private String updateRole;
	private String updateFirstname;
	private String updateLastname;
	private String updateNumber;
	private String updatePassword;
	private String updateEmail;
	
//  @Test
//  public void f() {
//// define the chrome driver
//	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
//	  WebDriver driver = new ChromeDriver();
//	  // navigate to "home"
//	  driver.get("http://localhost:8090/SourceMe/home");
//	  
//// REGISTER
//	  // navigate to register page
//	  driver.findElement(By.linkText("Sign Up")).click();
//	  // check if navigated to "registerPage"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
//	  
//	  // fill in registration form
//	  Select registerRole = new Select(driver.findElement(By.id("registerRole")));
//	  registerRole.selectByVisibleText("User");
//	  driver.findElement(By.id("registerFirstname")).sendKeys(registerFirstname);
//	  driver.findElement(By.id("registerLastname")).sendKeys(registerLastname);
//	  driver.findElement(By.id("registerNumber")).sendKeys(registerNumber);
//	  driver.findElement(By.id("registerUsername")).sendKeys(registerUsername);
//	  driver.findElement(By.id("registerPassword")).sendKeys(registerPassword);
//	  driver.findElement(By.id("registerEmail")).sendKeys(registerEmail);
//	  
//	  // submit registration form
//	  driver.findElement(By.id("registerBtn")).click();
//	  
//	  // check if navigated to "loginPage"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
//	  
//// LOGIN
//	  //fill in login form
//	  driver.findElement(By.id("loginUsername")).sendKeys(registerUsername);
//	  driver.findElement(By.id("loginPassword")).sendKeys(registerPassword);
//	  
//	  // submit login form
//	  driver.findElement(By.id("loginBtn")).click();
//	  
//	  // check if navigated to "edit"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
//	  
//	  // check navbar items. Visible: profile & logout. Invisible: login & register
//	  driver.findElement(By.linkText(registerUsername));
//	  driver.findElement(By.id("logoutBtn"));
//	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='signinNav']")).size() == 0);
//	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='signupNav']")).size() == 0);
//	  
//// UPDATE PROFILE
//	  // check if profile form is pre-populated
//	  String oldRole = driver.findElement(By.id("updateRole")).getAttribute("value");
//	  String oldFirstname = driver.findElement(By.id("updateFirstname")).getAttribute("value");
//	  String oldLastname = driver.findElement(By.id("updateLastname")).getAttribute("value");
//	  String oldNumber = driver.findElement(By.id("updateNumber")).getAttribute("value");
//	  String username = driver.findElement(By.id("username")).getAttribute("value");
//	  String oldPassword = driver.findElement(By.id("updatePassword")).getAttribute("value");
//	  String oldEmail = driver.findElement(By.id("updateEmail")).getAttribute("value");
//	  Assert.assertTrue(oldRole.equals("User"));
//	  Assert.assertTrue(oldFirstname.equals(registerFirstname));
//	  Assert.assertTrue(oldLastname.equals(registerLastname));
//	  Assert.assertTrue(oldNumber.equals(registerNumber));
//	  Assert.assertTrue(username.equals(registerUsername));
//	  Assert.assertTrue(oldPassword.equals(registerPassword));
//	  Assert.assertTrue(oldEmail.equals(registerEmail));
//	  
//	  // fill in profile form
//	  Select updateRole = new Select(driver.findElement(By.id("updateRole")));
//	  updateRole.selectByVisibleText("Admin");
//	  driver.findElement(By.id("updateFirstname")).clear();
//	  driver.findElement(By.id("updateLastname")).clear();
//	  driver.findElement(By.id("updateNumber")).clear();
//	  driver.findElement(By.id("updatePassword")).clear();
//	  driver.findElement(By.id("updateEmail")).clear();
//	  driver.findElement(By.id("updateFirstname")).sendKeys(updateFirstname);
//	  driver.findElement(By.id("updateLastname")).sendKeys(updateLastname);
//	  driver.findElement(By.id("updateNumber")).sendKeys(updateNumber);
//	  driver.findElement(By.id("updatePassword")).sendKeys(updatePassword);
//	  driver.findElement(By.id("updateEmail")).sendKeys(updateEmail);
//	  
//	  // submit profile form
//	  driver.findElement(By.id("updateBtn")).click();
//	  
//	  // check if profile form is updated with new details after page refresh
//	  String newRole = driver.findElement(By.id("updateRole")).getAttribute("value");
//	  String newFirstname = driver.findElement(By.id("updateFirstname")).getAttribute("value");
//	  String newLastname = driver.findElement(By.id("updateLastname")).getAttribute("value");
//	  String newNumber = driver.findElement(By.id("updateNumber")).getAttribute("value");
//	  username = driver.findElement(By.id("username")).getAttribute("value");
//	  String newPassword = driver.findElement(By.id("updatePassword")).getAttribute("value");
//	  String newEmail = driver.findElement(By.id("updateEmail")).getAttribute("value");
//	  Assert.assertTrue(newRole.equals("Admin"));
//	  Assert.assertTrue(newFirstname.equals(updateFirstname));
//	  Assert.assertTrue(newLastname.equals(updateLastname));
//	  Assert.assertTrue(newNumber.equals(updateNumber));
//	  Assert.assertTrue(username.equals(registerUsername));
//	  Assert.assertTrue(newPassword.equals(updatePassword));
//	  Assert.assertTrue(newEmail.equals(updateEmail));
//	  
//// CHECK IF HOME NAV LINK WORKS (IN PROFILE PAGE)
//	  // click on home nav link
//	  driver.findElement(By.linkText("Home")).click();
//	  
//	  // check if navigated to "home"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/home", driver.getCurrentUrl());
//	  
//// CHECK IF PROFILE NAV LINK WORKS (IN HOME PAGE)
//	  // click on profile nav link
//	  driver.findElement(By.linkText(registerUsername)).click();
//	  
//	  // check if navigated to "edit"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
//	  
//// LOGOUT (IN PROFILE PAGE)
//	  // click on logout nav link
//	  driver.findElement(By.id("logoutBtn")).click();
//	  
//	  // check if navigated to "loginPage"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
//	  
//	  // check navbar items. Visible: login & register. Invisible: profile & logout
//	  driver.findElement(By.id("signinNav"));
//	  driver.findElement(By.id("signupNav"));
//	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
//	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
//	  
//// NAVIGATE TO HOME PAGE
//	  // click on home nav link
//	  driver.findElement(By.linkText("Home")).click();
//	  
//	  // check if navigated to "home"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/home", driver.getCurrentUrl());
//	  
//// REGISTER WITH EXISTING USERNAME
//	  // navigate to register page
//	  driver.findElement(By.linkText("Sign Up")).click();
//	  // check if navigated to "registerPage"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
//	  
//	  // fill in registration form
//	  driver.findElement(By.id("registerFirstname")).sendKeys("existingUsernameTest");
//	  driver.findElement(By.id("registerLastname")).sendKeys("existingUsernameTest");
//	  driver.findElement(By.id("registerNumber")).sendKeys("33333333");
//	  driver.findElement(By.id("registerUsername")).sendKeys(registerUsername);
//	  driver.findElement(By.id("registerPassword")).sendKeys("existingUsernameTest");
//	  driver.findElement(By.id("registerEmail")).sendKeys("existingUsernameTest@email.com");
//	  
//	  // submit registration form
//	  driver.findElement(By.id("registerBtn")).click();
//	  
//	  // check if navigated to "loginPage"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/register", driver.getCurrentUrl());
//	  
//	  // check for error message
//	  driver.findElements(By.xpath("//*[contains(text(), 'Username already exists!')]"));
//	  
//	  // navigate to "home"
//	  driver.get("http://localhost:8090/SourceMe/home");
//	  
//// LOGIN WITH WRONG USERNAME
//	  // click on login link
//	  driver.findElement(By.linkText("Sign In")).click();
//	  
//	  // check if navigated to "loginPage"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
//	  
//	  // fill in login form
//	  driver.findElement(By.id("loginUsername")).sendKeys(wrongUsername);
//	  driver.findElement(By.id("loginPassword")).sendKeys(updatePassword);
//	  
//	  // submit login form
//	  driver.findElement(By.id("loginBtn")).click();
//	  
//	  // check if navigated to "login"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
//	  
//	  // check for error message
//	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
//	  
//// LOGIN WITH WRONG PASSWORD
//	  // nagivate the browser to "loginPage"
//	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
//	  
//	  // fill in login form
//	  driver.findElement(By.id("loginUsername")).sendKeys(registerUsername);
//	  driver.findElement(By.id("loginPassword")).sendKeys(wrongPassword);
//	  
//	  // submit login form
//	  driver.findElement(By.id("loginBtn")).click();
//	  
//	  // check if navigated to "login"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
//	  
//	  // check for error message
//	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
//	  
//// LOGIN WITH WRONG USERNAME AND PASSWORD
//	  // nagivate the browser to "loginPage"
//	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
//	  
//	  // fill in login form
//	  driver.findElement(By.id("loginUsername")).sendKeys(wrongUsername);
//	  driver.findElement(By.id("loginPassword")).sendKeys(wrongPassword);
//	  
//	  // submit login form
//	  driver.findElement(By.id("loginBtn")).click();
//	  
//	  // check if navigated to "login"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
//	  
//	  // check for error message
//	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
//	  
//	  // nagivate the browser to "loginPage"
//	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
//	  
//// LOGIN WITH UPDATED USERNAME AND PASSWORD
//	  // fill in login form
//	  driver.findElement(By.id("loginUsername")).sendKeys(registerUsername);
//	  driver.findElement(By.id("loginPassword")).sendKeys(updatePassword);
//	  
//	  // submit login form
//	  driver.findElement(By.id("loginBtn")).click();
//	  
//	  // check if navigated to "edit"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
//	  
//// DELETE ACCOUNT
//	  // click on delete account button
//	  driver.findElement(By.id("deleteBtn")).click();
//	  
//	  // check if navigated to "registerPage"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
//	  
//// CHECK LOGIN AND REGISTER LINKS AT THE BOTTOM OF THE FORMS
//	  driver.findElement(By.linkText("Login")).click();
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
//	  driver.findElement(By.linkText("click here")).click();
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
//	  
//// NAVIGATE TO PROFILE AS GUEST
//	  // navigate to "edit"
//	  driver.get("http://localhost:8090/SourceMe/UserServlet/edit");
//	  // check if redirected to "loginPage"
//	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
//  }
  
  
// *****************************************************************************
  
  
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
	  
	  // fill in login form
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("loginPassword")).sendKeys(wrongPassword);
	  
	  // submit login form
	  driver.findElement(By.id("loginBtn")).click();
	  
	  // check if navigated to "login"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
	  
	  // check for error message
	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
	  
// LOGIN FAIL (WRONG USERNAME AND PASSWORD)
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  
	  // fill in login form
	  driver.findElement(By.id("loginUsername")).sendKeys(wrongUsername);
	  driver.findElement(By.id("loginPassword")).sendKeys(wrongPassword);
	  
	  // submit login form
	  driver.findElement(By.id("loginBtn")).click();
	  
	  // check if navigated to "login"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
	  
	  // check for error message
	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
	  
// LOGIN SUCCESS
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  
	  // fill in login form
	  driver.findElement(By.id("loginUsername")).sendKeys(existingUsername1);
	  driver.findElement(By.id("loginPassword")).sendKeys(existingPassword1);
	  
	  // submit login form
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
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
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
	  existingRole1 = "Admin";
	  existingFirstname1 = "Jane";
	  existingLastname1 = "Doe";
	  existingNumber1 = "12345678";
	  existingUsername1 = "admin1";
	  existingPassword1 = "password";
	  existingEmail1 = "admin1@email.com";
	  
	  existingRole2 = "User";
	  existingFirstname2 = "John";
	  existingLastname2 = "Doe";
	  existingNumber2 = "12345678";
	  existingUsername2 = "user1";
	  existingPassword2 = "password";
	  existingEmail2 = "user1@email.com";
	  
	  existingRole3 = "User";
	  existingFirstname3 = "Jessie";
	  existingLastname3 = "Doe";
	  existingNumber3 = "12345678";
	  existingUsername3 = "user2";
	  existingPassword3 = "password";
	  existingEmail3 = "user2@email.com";
	  
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
