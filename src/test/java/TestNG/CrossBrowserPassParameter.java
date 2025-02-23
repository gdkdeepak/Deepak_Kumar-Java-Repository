package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserPassParameter 
{
	WebDriver driver;
	
	@Parameters({"UserName","Password","browser"})
	@Test
	public void LogIn(String uname, String pass, String webbrowser)
	{
		switch(webbrowser) 
		{
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			System.err.println("Browser not defined");
			break;
		}
				
		// Maximize the window
		driver.manage().window().maximize();

		// Entering Form Url 
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		// Enter username
		driver.findElement(By.xpath("//input[@name='username']")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(uname);
		
		// Enter password
		driver.findElement(By.xpath("//input[@name='password']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		
		// Click submit
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		
		// click logout
		driver.findElement(By.linkText("Log out")).click();
		
		// Scroll down
		js.executeScript("window.scrollBy(0,350)", "");
	}

}
