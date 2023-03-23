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

public class DownloadFile 
{
	public static void main(String[] args) throws InterruptedException
	{
	//location of chrome driver
	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

	// Downloaded file path saving loaction
	String fileDownloadPath = "C:\\Users\\Deepak\\CodoidInterview\\SeleniumDownload";

	Map<String, Object> prefsMap = new HashMap<String, Object>();
	prefsMap.put("profile.default_content_settings.popups", 0);
	prefsMap.put("download.default_directory", fileDownloadPath);

	ChromeOptions option = new ChromeOptions();
	option.setExperimentalOption("prefs", prefsMap);
	option.addArguments("--test-type");
	option.addArguments("--disable-extensions");

	//chrome driver setup
	WebDriver driver  = new ChromeDriver(option);

	//get url
	driver.get("https://www.seleniumhq.org/download/");

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	Thread.sleep(2000);

	// clicking the dowloadable file using web element
	driver.findElement(By.linkText("64 bit Windows IE")).click();
	System.out.println("Downloaded");
	}


}
