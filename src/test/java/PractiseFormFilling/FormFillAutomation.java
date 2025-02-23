package PractiseFormFilling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormFillAutomation 
{
	@Test(dataProvider = "getData", dataProviderClass = GiveData.class)	
	public void Login(String email, String pass)
	{
		
	// Open Browser	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("https://letcode.in/signin");
	driver.manage().window().maximize();
	
	
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
	

	
	driver.findElement(By.xpath("//button[.='LOGIN']")).click();
	
	}


}
