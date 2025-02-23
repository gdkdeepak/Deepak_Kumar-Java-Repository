package NewSeleniumProject;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScreenShot 
{
	public static WebDriver driver;

	@BeforeClass
	public static void Launch()
	{
	WebDriverManager.chromedriver().setup();
	System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
	driver = new ChromeDriver();

	// implicit wait
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	//maximize the window
	driver.manage().window().maximize();
	
	//Go to desired Web Page
	driver.get("https://www.cricbuzz.com/");
	}

	@Test
	public void Execute()
	{
	ScrnShot();
	}

	private static void ScrnShot()
	{
	String filename = "ScrnShot.jpg";	// image filename

	TakesScreenshot variable = (TakesScreenshot)driver;
	File file = variable.getScreenshotAs(OutputType.FILE);
	try
	{
	// saving the image
	FileUtils.copyFile(file, new File("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\"+filename));
	}
	catch(IOException e)
	{
	e.printStackTrace();
	}
	}

	//@AfterClass
	public static void CloseBrowser()
	{
	driver.quit();
	}

}
