package sel;

import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_Upload 
{
	{
		public static Webdriver driver;

		@BeforeClass
		public static void Launch()
		{
		WebDriverManager.chromedriver().setup();
		System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
		driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10.TimeUnit.SECONDS);

		//maximize the window
		driver.manage().window().maximize();


		// url
		driver.get("https://www.foundit.in/seeker/registration");

		}

		@Test
		public void Execute()
		{
		FileUpload();
		}

		private static void FileUpload()
		{
		//click on ‘Choose CV’ to upload the desired file
		WebElement element = driver.findElement(By.xpath("//input[@id='file-upload']"));

		//Uploading the file using sendKeys
		element.sendKeys("C:\\Users\\Deepak\\Desktop\\Files\\resume.txt");
		System.out.println("File is Uploaded Successfully");

		}

		@AfterClass
		public static void CloseBrowser()
		{
		driver.close();
		}
}
