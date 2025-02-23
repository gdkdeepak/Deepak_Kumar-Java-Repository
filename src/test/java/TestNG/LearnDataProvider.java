package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnDataProvider 
{
	@DataProvider(name = "Login", indices = {1,0})
	public String[][] getData()
	{
		String[][] data = new String[3][2];
		
		data[0][0]="kowshik350@gmail.com";
		data[0][1]="Pass123$";
		data[1][0]="kowshik1@letcode.in";
		data[1][1]="Pass123$";
		data[2][0]="deekay@gmail.com";
		data[2][1]="Pas==123$";
		
		return data;
	}
	
	@Test(dataProvider = "Login")
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
