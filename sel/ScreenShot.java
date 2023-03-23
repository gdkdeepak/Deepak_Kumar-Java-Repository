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

import org.openqa.selenium.TakesScreenshot;

public class ScreenShot 
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
	}

	@Test
	public void Execute()
	{
	ScrnShot();
	}

	private static void ScrnShot()
	{
	String filename = "1.jpg";	// image filename

	TakesScreenshot variable = (TakesScreenshot)driver;
	File file = variable.getScreenshotAs(OutputType.FILE);
	try
	{
	// saving the image
	FileUtils.copyFile(file, new File("C:\\Users\\Deepak\\Desktop\\SeleniumwithJAva\\"+filename));
	}
	catch(IOException e)
	{
	e.printStackTrace();
	}
	}

	@AfterClass
	public static void CloseBrowser()
	{
	driver.quit();
	}

}
