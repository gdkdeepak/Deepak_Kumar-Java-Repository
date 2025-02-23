package NewSeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

public class BrowserLaunch 
{
	// Launch the Chrome Browser and Navigate the WebPage
	@Test
	public void Execute()
	{
		
	// Open Chrome Browser using Chrome Driver
	WebDriverManager.chromedriver().setup();
	System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
	WebDriver driver = new ChromeDriver();

	// Maximize the window
	driver.manage().window().maximize();

	// Entering Amazon Url 
	driver.get("https://www.amazon.com/");
	
	// Navigate Back
	driver.navigate().back();
	
	// Navigate Forward
	driver.navigate().forward();
	
	// Refresh the Page
	driver.navigate().refresh();
	
	// Print Current WebPage URL
	String Current_Url=driver.getCurrentUrl();
	System.out.println(" Current WebPage URL : "+Current_Url);
	
	// Print Current WebPage Title
	String Current_PageTitle=driver.getTitle();
	System.out.println(" Current WebPage Title : "+Current_PageTitle);
	
	// Print Current Page Source
	String PageSource=driver.getPageSource();
	System.out.println(" Page Source : \n"+PageSource);
	
	// Close the Browser (Terminate only current browser)
	//driver.close();
	
	// Quit (Terminate Current Browser as well as driver.exe)
	//driver.quit();
	
	}
}
