package com.sddevops.SourceMe;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;



public class TutorialTest {
private WebDriver driver;
private JavascriptExecutor scroll;
@Test
public void a_getAllTutorials() throws InterruptedException{
// nagivate the browser to this url
driver.get("http://localhost:8090/SourceMe/home");
Thread.sleep(2000);
// Get all tutorials
driver.findElement(By.linkText("All Tutorials")).click();
scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
Thread.sleep(2000);
System.out.println("GetAll");
}

@Test
public void b_createTutorial() throws InterruptedException{
// nagivate the browser to this url
driver.get("http://localhost:8090/SourceMe/home");
Thread.sleep(2000);
//Click on 'sign in' button
driver.findElement(By.linkText("Sign In")).click();
Thread.sleep(2000);
//Enter credentials for Admin
driver.findElement(By.name("userName")).sendKeys("Ad");
driver.findElement(By.name("password")).sendKeys("admin@123");
Thread.sleep(2000);
//Click on 'login' button
driver.findElement(By.id("login")).click();
Thread.sleep(2000);
//Click on 'All tutorials' button on navigation bar
driver.findElement(By.linkText("All Tutorials")).click();
Thread.sleep(2000);
//Click on 'create tutorial' button
driver.findElement(By.id("createTutorial")).click();
Thread.sleep(2000);
//Enter title and content
driver.findElement(By.id("title")).sendKeys("testing");
driver.findElement(By.id("content")).sendKeys("Tutorials testing");
Thread.sleep(1000);
scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
Thread.sleep(2000);
//Click on 'submit tutorial' button
driver.findElement(By.id("submitAnswer")).submit();
scroll.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
Thread.sleep(2000);
//logout
driver.findElement(By.linkText("Logout")).click();
Thread.sleep(2000);
System.out.println("Create");
}



@Test
public void c_getTutorialById() throws InterruptedException{
// nagivate the browser to this url
driver.get("http://localhost:8090/SourceMe/home");
Thread.sleep(2000);
//Click on 'sign in' button
driver.findElement(By.linkText("Sign In")).click();
Thread.sleep(2000);
//Enter credentials for Admin
driver.findElement(By.name("userName")).sendKeys("Ad");
driver.findElement(By.name("password")).sendKeys("admin@123");
Thread.sleep(2000);
//Click on 'login' button
driver.findElement(By.id("login")).click();
Thread.sleep(2000);
//Click on "All tutorials" button
driver.findElement(By.linkText("All Tutorials")).click();
Thread.sleep(2000);
//Click on 'edit' button
driver.findElement(By.linkText("Edit")).click();
Thread.sleep(2000);
//logout
driver.findElement(By.linkText("Logout")).click();
Thread.sleep(2000);
System.out.println("GetByid");
}

@Test
public void d_editTutorialById() throws InterruptedException{
// nagivate the browser to this url
driver.get("http://localhost:8090/SourceMe/home");
Thread.sleep(2000);
//Click on 'sign in' button
driver.findElement(By.linkText("Sign In")).click();
Thread.sleep(2000);
//Enter credentials for Admin
driver.findElement(By.name("userName")).sendKeys("Ad");
driver.findElement(By.name("password")).sendKeys("admin@123");
Thread.sleep(2000);
//Click on 'login' button
driver.findElement(By.id("login")).click();
Thread.sleep(2000);
//Click on "All tutorials" button
driver.findElement(By.linkText("All Tutorials")).click();
Thread.sleep(2000);
//Click on 'edit' button
driver.findElement(By.linkText("Edit")).click();
Thread.sleep(2000);
//Make changes to title/content
//Clear previous input
driver.findElement(By.id("title")).clear();
driver.findElement(By.id("tutorial")).clear();
Thread.sleep(1500);
driver.findElement(By.id("title")).sendKeys("testing devops");
driver.findElement(By.id("tutorial")).sendKeys("Tutorials testing devops");
Thread.sleep(2000);
//Click on 'submit tutorial'
driver.findElement(By.id("submitAnswer")).submit();
Thread.sleep(2000);
//logout
driver.findElement(By.linkText("Logout")).click();
Thread.sleep(2000);
System.out.println("Update");
}

@Test
public void e_deleteTutorial() throws InterruptedException{
// nagivate the browser to this url
driver.get("http://localhost:8090/SourceMe/home");
Thread.sleep(2000);
//Click on 'sign in' button
driver.findElement(By.linkText("Sign In")).click();
Thread.sleep(2000);
//Enter credentials for Admin
driver.findElement(By.name("userName")).sendKeys("Ad");
driver.findElement(By.name("password")).sendKeys("admin@123");
Thread.sleep(2000);
//Click on 'login' button
driver.findElement(By.id("login")).click();
Thread.sleep(2000);
//Click on "All tutorials" button
driver.findElement(By.linkText("All Tutorials")).click();
Thread.sleep(2000);
//Click on 'delete' button
driver.findElement(By.linkText("Delete")).click();
Thread.sleep(2000);

//logout
driver.findElement(By.linkText("Logout")).click();
Thread.sleep(2000);
System.out.println("Delete");
}

@BeforeTest
public void beforeTest() {
// define the chrome driver
System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");



// define the drive instance
driver = new ChromeDriver();

scroll = (JavascriptExecutor) driver;
}



@AfterTest
public void afterTest() {
}



}