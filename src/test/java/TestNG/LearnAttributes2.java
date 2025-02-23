package TestNG;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnAttributes2 
{
	//@Test( invocationCount = 3 , threadPoolSize = 2)
	public void FindElements()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("ipl2023",Keys.ENTER);
	
	}
	
	//@Test(timeOut = 2000) // ThreadTimeoutException
	//@Test(expectedExceptions = {org.openqa.selenium.NoSuchElementException.class, org.testng.TestException.class})
	@Test // for parallel example
	public void FindElements2()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("odi world cup",Keys.ENTER); // parale mode example
	//	driver.findElement(By.xpath("//textarea[@class='g00LFyf']")).sendKeys("odi world cup",Keys.ENTER); // NoSuchElementException
		
	}
	/*
	Note :
	1) threadPoolSize
	2) timeOut
	3) invocationCount
	4) invocationTimeOut
	5) expectedExceptions
	
	*/
}
