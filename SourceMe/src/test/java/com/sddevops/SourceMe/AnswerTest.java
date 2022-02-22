package com.sddevops.SourceMe;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AnswerTest {
//	public WebDriver driver;
//	public JavascriptExecutor js;
//	
//	
//	@Test
//	  public void aCreateAnswer() throws InterruptedException {
//		//Starting page
//		driver.get("http://localhost:8080/SourceMe/home");
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//		//Click on "All Question" button
//		driver.findElement(By.name("questions")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//		//Click on �View Answer� button
//	    driver.findElement(By.linkText("View Answer")).click();
//	    
//		//Click on �Add your Answer� button
//	    driver.findElement(By.name("btn-add-answer")).click();
//	    
//		//Enter username
//	    driver.findElement(By.name("userName")).sendKeys("Ad");
//	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//		//Enter password
//	    driver.findElement(By.name("password")).sendKeys("admin@123");
//	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//		//Click on �login� button
//	    driver.findElement(By.id("login")).click();
//	    
//		//Click on �Home� button
//	    driver.findElement(By.linkText("Home")).click();
//	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//		//Click on �All Question� button
//	    driver.findElement(By.name("questions")).click();
//	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//                                 	    
//		//Click on �View Answer� button
//	    driver.findElement(By.linkText("View Answer")).click();
//	    
//		//Click on �Add your Answer� button
//	    driver.findElement(By.name("btn-add-answer")).click();
//	    
//		//Enter the answer
//	    driver.findElement(By.name("answer")).sendKeys("selenium testing");
//	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//		//Click on �Submit Answer� button
//	    driver.findElement(By.id("submitAnswer")).click();
//	    (js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
// 	}
//	
//  @Test
//  public void bGetAnswerByQnsId() throws InterruptedException {
//	  	//Starting page
//	  	driver.get("http://localhost:8080/SourceMe/home");
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//		//Click on �All Question� button
//		driver.findElement(By.name("questions")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//    		
//		//Click on �View Answer� button 
//	    driver.findElement(By.linkText("View Answer")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//  }
//  
//  @Test
//  public void cGetAnswerById() throws InterruptedException {
//	  	//Starting page
//	  	driver.get("http://localhost:8080/SourceMe/home");
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//		//Click on �All Question� button
//		driver.findElement(By.name("questions")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//		//Click on �View Answer� button 
//	    driver.findElement(By.linkText("View Answer")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//	    //Click on �edit� button 
//	    driver.findElement(By.name("editAnswer")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//  }
//  
//  @Test
//  public void dUpdateAnswerById() throws InterruptedException {
//	  	//Starting page
//	  	driver.get("http://localhost:8080/SourceMe/home");
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//		//Click on �All Question� button 
//		driver.findElement(By.name("questions")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//		//Click on �View Answer� button 
//	    driver.findElement(By.linkText("View Answer")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//		//Click on �edit� button 
//	    driver.findElement(By.name("editAnswer")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//	    
//	    //Clear previous input
//	    driver.findElement(By.name("answer")).clear();
//		
//		//Make changes to answer
//	    driver.findElement(By.name("answer")).sendKeys("selenium edited text");
//		
//		//Click on �Edit Answer� button
//	    driver.findElement(By.id("editAnswer")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//  }
//  
//  @Test
//  public void eDeleteAnswerById() throws InterruptedException {
//	  	//Starting page
//	  	driver.get("http://localhost:8080/SourceMe/home");
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//		//Click on �All Question� button 
//		driver.findElement(By.name("questions")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		
//	    //Click on �View Answer� button 
//	    driver.findElement(By.linkText("View Answer")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//						
//		//Click on �Delete� button
//	    driver.findElement(By.name("btnDel")).click();
//		(js).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//  }
//  
//  @BeforeTest
//  public void beforeTest() {
//	  System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
//	  driver = new ChromeDriver();
//	  js = (JavascriptExecutor) driver; 
//  }
//
//  @AfterTest
//  public void afterTest() {
//  }

}