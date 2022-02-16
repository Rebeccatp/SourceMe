package com.sddevops.SourceMe;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TutorialTest {
  @Test
  public void f() {
	// define the chrome driver
		  System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		  // define the drive instance
		 WebDriver driver = new ChromeDriver();
		 // nagivate the browser to this url
		 driver.get("http://localhost:8090/SourceMe/home");
		 // Guest
		 driver.findElement(By.linkText("All Tutorials")).click();

		  // Admin
		 driver.findElement(By.linkText("Sign In")).click();
		 driver.findElement(By.id("userName")).sendKeys("test");
		 driver.findElement(By.id("password")).sendKeys("1");
		 driver.findElement(By.id("submit")).submit();
		 driver.findElement(By.linkText("All Tutorials")).click();
		 driver.findElement(By.id("createTutorial")).click();
		 driver.findElement(By.id("title")).sendKeys("testing");
		 driver.findElement(By.id("content")).sendKeys("Tutorials testing");
		 driver.findElement(By.id("submitAnswer")).submit();
		 driver.findElement(By.linkText("Edit")).click();
		 driver.findElement(By.id("title")).sendKeys("testing devops");
		 driver.findElement(By.id("tutorial")).sendKeys("Tutorials testing devops");
		 driver.findElement(By.id("submitAnswer")).submit();
		 driver.findElement(By.linkText("Delete")).click();
		 driver.findElement(By.linkText("Logout")).click();
		 // User
		 driver.findElement(By.id("userName")).sendKeys("usertest");
		 driver.findElement(By.id("password")).sendKeys("1");
		 driver.findElement(By.id("submit")).submit();
		 driver.findElement(By.linkText("All Tutorials")).click();
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
