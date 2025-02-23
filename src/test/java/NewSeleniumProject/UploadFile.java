package NewSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class UploadFile 
{
	public static WebDriver driver;

	@BeforeClass
	public static void Launch()
	{
	WebDriverManager.chromedriver().setup();
	System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
	driver = new ChromeDriver();

	// Implicit wait
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	//Maximize the window
	driver.manage().window().maximize();


	// Navigating to the desired URL
	// File Upload Test Page
	driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");

	}

	@Test
	public void Execute()
	{
	FileUpload();
	}

	private static void FileUpload()
	{
	// Click on ‘Choose CV’ to upload the desired file
	WebElement element = driver.findElement(By.xpath("//input[@name='userfile']"));

	// Uploading the file using sendKeys
	element.sendKeys("C:\\Users\\ADMIN\\Downloads\\DEEPAK KUMAR Resume.pdf");
	System.out.println("File is Uploaded Successfully");
	}
	
	//@AfterClass
	public static void CloseBrowser()
	{
	driver.close();
	}
	
}
