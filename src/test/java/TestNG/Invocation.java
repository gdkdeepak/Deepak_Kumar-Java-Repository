package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Invocation
{
	@Test(invocationCount = 2, priority = -1)
	public void SignUp()
	{
		System.out.println("Sign Up");
	}

	@Test(invocationCount = 0)
	public void SignOut()
	{
		System.out.println("Sign Out ");
	}
	
	@Test (invocationCount = 1, priority = 2)
	public void Login()
	{
		System.out.println("Login");
	}
	
	@Test(dependsOnMethods = {"SearchProduct", "Login"},invocationCount = 3)
	public void addToCart()
	{
		System.out.println("addToCart ");
	}
	
	@Test(invocationCount = 0, priority = 2)
	public void SearchProduct()
	{
		System.out.println("SearchProduct");
		throw new RuntimeException();
	}
	
	// ThreadTimeoutException
	//	@Test(invocationTimeOut = 10000)
		public void Exceute()
		{
		// Open Chrome Browser using Chrome Driver
		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
		WebDriver driver = new ChromeDriver();

		// Maximize the window
		driver.manage().window().maximize();

		// Entering Amazon Url 
		driver.get("https://www.espncricinfo.com/");
		
		// Navigate Back
		driver.navigate().back();
		
		// Navigate Forward
		driver.navigate().forward();
		
		// Refresh the Page
		driver.navigate().refresh();
		
		// Print Current WebPage URL
		String Current_Url=driver.getCurrentUrl();
		System.out.println(" Current WebPage URL : "+Current_Url);
		
		// Print Current WebPage Title
		String Current_PageTitle=driver.getTitle();
		System.out.println(" Current WebPage Title : "+Current_PageTitle);
		
		}

}
