package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import LetsCodeIn_Project.DataGiver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDataProviderClass 
{
//	@Test(dataProvider = "Login", dataProviderClass = DataGiver.class) 
					// specifying name field & not specifying method name
	
	@Test(dataProvider = "getData", dataProviderClass = DataGiver.class)	
					// by ignoring name field and just specifying method name and class name 
	
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
