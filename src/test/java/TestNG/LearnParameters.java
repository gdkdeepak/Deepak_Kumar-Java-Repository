package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearnParameters 
{
	@Parameters({"UserName","Password"})
	@Test
	public void LogIn(String uname, String pass)
	{
		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
		WebDriver driver = new ChromeDriver();
		
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
