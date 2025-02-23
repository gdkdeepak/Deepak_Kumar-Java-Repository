package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDataProviderFromDifferentClass extends LetsCodeIn_Project.DataGiver
{		// Extending to a parent class from a different package 

//	@Test(dataProvider = "Login")	// using name field
	@Test(dataProvider = "getData")	// without using name field , using method name 
	public void Login(String email, String pass)
	{
		
	// Open Browser	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("https://letcode.in/");
	driver.manage().window().maximize();
	
	driver.findElement(By.linkText("Log in")).click();
	
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
	
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	
	}

}
