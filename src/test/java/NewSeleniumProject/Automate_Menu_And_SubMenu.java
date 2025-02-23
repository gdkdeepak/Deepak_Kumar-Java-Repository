package NewSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Automate_Menu_And_SubMenu 
{
	public static WebDriver driver;

	@BeforeClass
	public static void Launch()
	{
	// Launch Chrome Browser
	WebDriverManager.chromedriver().setup();
	System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
	driver = new ChromeDriver();

	// Implicit Wait 
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	//maximize the window
	driver.manage().window().maximize();

	// Enter to the Desired URL PAGE
	driver.get("https://www.amazon.com/");
	}

	@Test
	public void Execute()
	{
	SubMenuAction();
	}

	private static void SubMenuAction()
	{
	//Identify Menu Web Element
	WebElement m=driver.findElement(By.id("nav-link-accountList"));

	// Click the Menu
	Actions action = new Actions(driver);
	action.moveToElement(m).perform();
	
	// Implicit Wait 
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

	//Identify Sub-Menu Web  Element
	WebElement sm=driver.findElement(By.xpath("//*[text()='Create a List']"));

	//move to element and click
	action.moveToElement(sm).click().perform();
	
	// Returning the Title of the WebPage in the Selected Sub-Menu
	System.out.println("Page navigated to: " +driver.getTitle());
	
	}

	//@AfterClass
	public static void CloseBrowser()
	{
	driver.quit();
	}


}
