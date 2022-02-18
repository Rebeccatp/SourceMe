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
	
	private String registerFirstname = "selenium";
	private String registerLastname = "selenium";
	private String registerNumber = "1111111";
	private String registerUsername = "selenium";
	private String registerPassword = "selenium";
	private String registerEmail = "selenium@email.com";
	
	private String wrongUsername = "winnie";
	private String wrongPassword = "pooh";
	
	private String updateFirstname = "muineles";
	private String updateLastname = "muineles";
	private String updateNumber = "22222222";
	private String updatePassword = "muineles";
	private String updateEmail = "muineles@email.com";
	
  @Test
  public void registerLoginUpdateDelete() {
// define the chrome driver
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  // navigate to "home"
	  driver.get("http://localhost:8090/SourceMe/home");
	  
// REGISTER
	  // navigate to register page
	  driver.findElement(By.linkText("Sign Up")).click();
	  // check if navigated to "registerPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
	  
	  // fill in registration form
	  Select registerRole = new Select(driver.findElement(By.id("registerRole")));
	  registerRole.selectByVisibleText("User");
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
	  
// LOGIN
	  //fill in login form
	  driver.findElement(By.id("loginUsername")).sendKeys(registerUsername);
	  driver.findElement(By.id("loginPassword")).sendKeys(registerPassword);
	  
	  // submit login form
	  driver.findElement(By.id("loginBtn")).click();
	  
	  // check if navigated to "edit"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
	  // check navbar items. Visible: profile & logout. Invisible: login & register
	  driver.findElement(By.linkText(registerUsername));
	  driver.findElement(By.id("logoutBtn"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='signinNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='signupNav']")).size() == 0);
	  
// UPDATE PROFILE
	  // check if profile form is pre-populated
	  String oldRole = driver.findElement(By.id("updateRole")).getAttribute("value");
	  String oldFirstname = driver.findElement(By.id("updateFirstname")).getAttribute("value");
	  String oldLastname = driver.findElement(By.id("updateLastname")).getAttribute("value");
	  String oldNumber = driver.findElement(By.id("updateNumber")).getAttribute("value");
	  String username = driver.findElement(By.id("username")).getAttribute("value");
	  String oldPassword = driver.findElement(By.id("updatePassword")).getAttribute("value");
	  String oldEmail = driver.findElement(By.id("updateEmail")).getAttribute("value");
	  Assert.assertTrue(oldRole.equals("User"));
	  Assert.assertTrue(oldFirstname.equals(registerFirstname));
	  Assert.assertTrue(oldLastname.equals(registerLastname));
	  Assert.assertTrue(oldNumber.equals(registerNumber));
	  Assert.assertTrue(username.equals(registerUsername));
	  Assert.assertTrue(oldPassword.equals(registerPassword));
	  Assert.assertTrue(oldEmail.equals(registerEmail));
	  
	  // fill in profile form
	  Select updateRole = new Select(driver.findElement(By.id("updateRole")));
	  updateRole.selectByVisibleText("Admin");
	  driver.findElement(By.id("updateFirstname")).clear();
	  driver.findElement(By.id("updateLastname")).clear();
	  driver.findElement(By.id("updateNumber")).clear();
	  driver.findElement(By.id("updatePassword")).clear();
	  driver.findElement(By.id("updateEmail")).clear();
	  driver.findElement(By.id("updateFirstname")).sendKeys(updateFirstname);
	  driver.findElement(By.id("updateLastname")).sendKeys(updateLastname);
	  driver.findElement(By.id("updateNumber")).sendKeys(updateNumber);
	  driver.findElement(By.id("updatePassword")).sendKeys(updatePassword);
	  driver.findElement(By.id("updateEmail")).sendKeys(updateEmail);
	  
	  // submit profile form
	  driver.findElement(By.id("updateBtn")).click();
	  
	  // check if profile form is updated with new details after page refresh
	  String newRole = driver.findElement(By.id("updateRole")).getAttribute("value");
	  String newFirstname = driver.findElement(By.id("updateFirstname")).getAttribute("value");
	  String newLastname = driver.findElement(By.id("updateLastname")).getAttribute("value");
	  String newNumber = driver.findElement(By.id("updateNumber")).getAttribute("value");
	  username = driver.findElement(By.id("username")).getAttribute("value");
	  String newPassword = driver.findElement(By.id("updatePassword")).getAttribute("value");
	  String newEmail = driver.findElement(By.id("updateEmail")).getAttribute("value");
	  Assert.assertTrue(newRole.equals("Admin"));
	  Assert.assertTrue(newFirstname.equals(updateFirstname));
	  Assert.assertTrue(newLastname.equals(updateLastname));
	  Assert.assertTrue(newNumber.equals(updateNumber));
	  Assert.assertTrue(username.equals(registerUsername));
	  Assert.assertTrue(newPassword.equals(updatePassword));
	  Assert.assertTrue(newEmail.equals(updateEmail));
	  
// CHECK IF HOME NAV LINK WORKS (IN PROFILE PAGE)
	  // click on home nav link
	  driver.findElement(By.linkText("Home")).click();
	  
	  // check if navigated to "home"
	  Assert.assertEquals("http://localhost:8090/SourceMe/home", driver.getCurrentUrl());
	  
// CHECK IF PROFILE NAV LINK WORKS (IN HOME PAGE)
	  // click on profile nav link
	  driver.findElement(By.linkText(registerUsername)).click();
	  
	  // check if navigated to "edit"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
// LOGOUT (IN PROFILE PAGE)
	  // click on logout nav link
	  driver.findElement(By.id("logoutBtn")).click();
	  
	  // check if navigated to "loginPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
	  
	  // check navbar items. Visible: login & register. Invisible: profile & logout
	  driver.findElement(By.id("signinNav"));
	  driver.findElement(By.id("signupNav"));
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='profileNav']")).size() == 0);
	  Assert.assertTrue(driver.findElements(By.xpath("//a[@id='logoutBtn']")).size() == 0);
	  
// NAVIGATE TO HOME PAGE
	  // click on home nav link
	  driver.findElement(By.linkText("Home")).click();
	  
	  // check if navigated to "home"
	  Assert.assertEquals("http://localhost:8090/SourceMe/home", driver.getCurrentUrl());
	  
// REGISTER WITH EXISTING USERNAME
	  // navigate to register page
	  driver.findElement(By.linkText("Sign Up")).click();
	  // check if navigated to "registerPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
	  
	  // fill in registration form
	  driver.findElement(By.id("registerFirstname")).sendKeys("existingUsernameTest");
	  driver.findElement(By.id("registerLastname")).sendKeys("existingUsernameTest");
	  driver.findElement(By.id("registerNumber")).sendKeys("33333333");
	  driver.findElement(By.id("registerUsername")).sendKeys(registerUsername);
	  driver.findElement(By.id("registerPassword")).sendKeys("existingUsernameTest");
	  driver.findElement(By.id("registerEmail")).sendKeys("existingUsernameTest@email.com");
	  
	  // submit registration form
	  driver.findElement(By.id("registerBtn")).click();
	  
	  // check if navigated to "loginPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/register", driver.getCurrentUrl());
	  
	  // check for error message
	  driver.findElements(By.xpath("//*[contains(text(), 'Username already exists!')]"));
	  
	  // navigate to "home"
	  driver.get("http://localhost:8090/SourceMe/home");
	  
// LOGIN WITH WRONG USERNAME
	  // click on login link
	  driver.findElement(By.linkText("Sign In")).click();
	  
	  // check if navigated to "loginPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
	  
	  // fill in login form
	  driver.findElement(By.id("loginUsername")).sendKeys(wrongUsername);
	  driver.findElement(By.id("loginPassword")).sendKeys(updatePassword);
	  
	  // submit login form
	  driver.findElement(By.id("loginBtn")).click();
	  
	  // check if navigated to "login"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
	  
	  // check for error message
	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
	  
// LOGIN WITH WRONG PASSWORD
	  // nagivate the browser to "loginPage"
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  
	  // fill in login form
	  driver.findElement(By.id("loginUsername")).sendKeys(registerUsername);
	  driver.findElement(By.id("loginPassword")).sendKeys(wrongPassword);
	  
	  // submit login form
	  driver.findElement(By.id("loginBtn")).click();
	  
	  // check if navigated to "login"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/login", driver.getCurrentUrl());
	  
	  // check for error message
	  driver.findElements(By.xpath("//*[contains(text(), 'Wrong username or password!')]"));
	  
// LOGIN WITH WRONG USERNAME AND PASSWORD
	  // nagivate the browser to "loginPage"
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
	  
	  // nagivate the browser to "loginPage"
	  driver.get("http://localhost:8090/SourceMe/UserServlet/loginPage");
	  
// LOGIN WITH UPDATED USERNAME AND PASSWORD
	  // fill in login form
	  driver.findElement(By.id("loginUsername")).sendKeys(registerUsername);
	  driver.findElement(By.id("loginPassword")).sendKeys(updatePassword);
	  
	  // submit login form
	  driver.findElement(By.id("loginBtn")).click();
	  
	  // check if navigated to "edit"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/edit", driver.getCurrentUrl());
	  
// DELETE ACCOUNT
	  // click on delete account button
	  driver.findElement(By.id("deleteBtn")).click();
	  
	  // check if navigated to "registerPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
	  
// CHECK LOGIN AND REGISTER LINKS AT THE BOTTOM OF THE FORMS
	  driver.findElement(By.linkText("Login")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
	  driver.findElement(By.linkText("click here")).click();
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/registerPage", driver.getCurrentUrl());
	  
// NAVIGATE TO PROFILE AS GUEST
	  // navigate to "edit"
	  driver.get("http://localhost:8090/SourceMe/UserServlet/edit");
	  // check if redirected to "loginPage"
	  Assert.assertEquals("http://localhost:8090/SourceMe/UserServlet/loginPage", driver.getCurrentUrl());
  }
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
