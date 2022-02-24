package com.sddevops.SourceMe;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AnswerTest {
	public WebDriver driver;
	public JavascriptExecutor js;
	
	
	@Test
	  public void aCreateAnswer() throws InterruptedException {
		//Starting page
		driver.get("http://localhost:8090/SourceMe/home");
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(800);
		
		//Click on "All Question" button
		driver.findElement(By.name("questions")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
		//Click on "View Answer" button
	    driver.findElement(By.linkText("View Answer")).click();
	    Thread.sleep(800);
	    
		//Click on "Add your Answer" button
	    driver.findElement(By.name("btn-add-answer")).click();
	    Thread.sleep(800); 
	    
		//Enter username
	    driver.findElement(By.name("userName")).sendKeys("Ad");
	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
		//Enter password
	    driver.findElement(By.name("password")).sendKeys("admin@123");
	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
		//Click on "login" button
	    driver.findElement(By.id("login")).click();
	    Thread.sleep(800);
	    
		//Click on "Home" button
	    driver.findElement(By.linkText("Home")).click();
	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
		//Click on "All Question" button
	    driver.findElement(By.name("questions")).click();
	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
		//Click on "View Answer" button
	    driver.findElement(By.linkText("View Answer")).click();
	    Thread.sleep(800);
	    
		//Click on "Add your Answer" button
	    driver.findElement(By.name("btn-add-answer")).click();
	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");

	    Thread.sleep(800);
	    
		//Enter the answer
	    driver.findElement(By.name("answer")).sendKeys("selenium testing");
	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
		//Click on "Submit Answer" button
	    driver.findElement(By.id("submitAnswer")).click();
	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	}
	
  @Test
  public void bGetAnswerByQnsId() throws InterruptedException {
	  	//Starting page
	  	driver.get("http://localhost:8090/SourceMe/home");
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(800);
		
		//Click on "All Question" button
		driver.findElement(By.name("questions")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
		
		//Click on "View Answer" button 
	    driver.findElement(By.linkText("View Answer")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
  }
  
  @Test
  public void cGetAnswerById() throws InterruptedException {
	  	//Starting page
	  	driver.get("http://localhost:8090/SourceMe/home");
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(800);
		
		//Click on "All Question" button
		driver.findElement(By.name("questions")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
		
		//Click on "View Answer" button 
	    driver.findElement(By.linkText("View Answer")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
	    //Click on "edit" button 
	    driver.findElement(By.name("editAnswer")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
  }
  
  @Test
  public void dUpdateAnswerById() throws InterruptedException {
	  	//Starting page
	  	driver.get("http://localhost:8090/SourceMe/home");
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(800);
		
		//Click on "All Question" button 
		driver.findElement(By.name("questions")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
		//Click on View Answer button 
	    driver.findElement(By.linkText("View Answer")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
		
		//Click on edit button 
	    driver.findElement(By.name("editAnswer")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
	    
	    //Clear previous input
	    driver.findElement(By.name("answer")).clear();
		
		//Make changes to answer
	    driver.findElement(By.name("answer")).sendKeys("selenium edited text");
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
		
		//Click on Edit Answer button
	    driver.findElement(By.id("editAnswer")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
  }
  
  @Test
  public void eDeleteAnswerById() throws InterruptedException {
	  	//Starting page
	  	driver.get("http://localhost:8090/SourceMe/home");
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(800);
		
		//Click on All Question button 
		driver.findElement(By.name("questions")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);  
		
	    //Click on View Answer button 
	    driver.findElement(By.linkText("View Answer")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800); 
						
		//Click on Delete button
	    driver.findElement(By.name("btnDel")).click();
		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	    Thread.sleep(800);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
	  driver = new ChromeDriver();
	  js = (JavascriptExecutor) driver; 
  }

  @AfterTest
  public void afterTest() {
  }

}
