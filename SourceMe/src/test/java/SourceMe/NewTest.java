//package SourceMe;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//
//public class NewTest {
//	private WebDriver driver;
////  @Test 
////  public void f() throws InterruptedException {
////	// define the chrome driver
////			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
////			// define the drive instance
////			WebDriver driver = new ChromeDriver();
////			// tell browser open to maximize before we load the page
////			driver.manage().window().maximize();		
////  }
//
//	//user try to add a question before they even login
//	@Test
//	public void a() throws InterruptedException {
//		// navigate the browser to this url
//		driver.get("http://localhost:8090/SourceMe/home.jsp");
//		Thread.sleep(950);
//
//		// hit all questions button
//		driver.findElement(By.name("questions")).click();
//		Thread.sleep(950);
//
//		// get to the list of question page
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//
//		// hit add question button
//		driver.findElement(By.linkText("Add Your Question")).click();
//		Thread.sleep(950);
//	}
//
//	//login
//	@Test
//	public void b() throws InterruptedException {
//		// get to the login page as we need to login then can add a question
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//
//		// fill up the login details
//		driver.findElement(By.name("userName")).sendKeys("Ad");
//		driver.findElement(By.name("password")).sendKeys("admin@123");
//		Thread.sleep(950);
//
//		// hit login button
//		driver.findElement(By.id("login")).click();
//		Thread.sleep(950);
//
//		// navigate to account page
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//	}
//	
//	//user try to add a question again
//	@Test
//	public void c() throws InterruptedException {
//		// hit add question button
//		driver.findElement(By.linkText("Add Your Question")).click();
//		Thread.sleep(950);
//
//		// get to the add question page
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//
//		// fill up the question details
//		driver.findElement(By.name("title")).sendKeys("CPOP");
//		driver.findElement(By.name("question")).sendKeys("Eric Chou songs to recommend");
//		Thread.sleep(950);
//
//		// hit submit button
//		driver.findElement(By.id("submitQuestion")).click();
//		Thread.sleep(950);
//
//		// get to the question added page
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//
//		// hit back to main button to navigate back to list of question page
//		driver.findElement(By.linkText("Back to main")).click();
//		Thread.sleep(950);
//
//		// get back to the list of questions page
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//	}
//
//	//user try to edit question
//	@Test
//	public void d() throws InterruptedException {
//		// hit edit button
//		driver.findElement(By.linkText("Edit")).click();
//		Thread.sleep(950);
//
//		// get to the edit question page
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//
//		// click on back button
//		driver.findElement(By.id("back")).click();
//		Thread.sleep(950);
//
//		// get to list of question page
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//
//		// hit edit button again
//		driver.findElement(By.linkText("Edit")).click();
//		Thread.sleep(950);
//
//		// edit the details of the question
//		driver.findElement(By.name("title")).clear();
//		driver.findElement(By.name("question")).clear();
//
//		driver.findElement(By.name("title")).sendKeys("Shows and song");
//		driver.findElement(By.name("question")).sendKeys("Chinese shows and or song that have Kris Wu");
//		Thread.sleep(950);
//
//		// hit save changes button
//		driver.findElement(By.id("editQns")).click();
//		Thread.sleep(950);
//
//		// navigate back to list of question page to check if question is edited
//		driver.getCurrentUrl();
//		Thread.sleep(950);
//	}
//
//	//user try to delete qn
//	@Test
//	public void e() throws InterruptedException {
//		// hit delete question button
//		driver.findElement(By.linkText("Delete")).click();
//		Thread.sleep(950);
//
//		// navigate back to list of question page to see if question is removed
//		driver.getCurrentUrl();
//		Thread.sleep(1050);
//	}
//
//	@BeforeTest
//	public void beforeTest() {
//		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//	}
//
//	@AfterTest
//	public void afterTest() {
//		//driver.quit();
//	}
//
//}
