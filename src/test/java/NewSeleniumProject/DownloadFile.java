package NewSeleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile 
{
	public static void main(String[] args) 
	{

	// Downloaded file path saving loaction
	String fileDownloadPath = "C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject";

	HashMap<String, Object> prefsMap = new HashMap<String, Object>();
	prefsMap.put("profile.default_content_settings.popups", 0);
	prefsMap.put("download.default_directory", fileDownloadPath);

	ChromeOptions option = new ChromeOptions();
	option.setExperimentalOption("prefs", prefsMap);
	option.addArguments("--test-type");
	option.addArguments("--disable-extensions");

	//Chrome driver setup
	WebDriverManager.chromedriver().setup();
	System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
	WebDriver driver  = new ChromeDriver(option);

	// Maximize the WebPage 
	driver.manage().window().maximize();

	//get url
	driver.get("https://filesamples.com/formats/pdf");

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");
	
	// clicking the dowloadable file using web element
	WebElement w = driver.findElement(By.xpath("//a[@href='/samples/document/pdf/sample3.pdf']"));
	Actions act = new Actions(driver);
	act.moveToElement(w).doubleClick().build().perform();
	
	System.out.println("File Downloaded Successfully");
	
	// driver.close();
	
	}
	
}
