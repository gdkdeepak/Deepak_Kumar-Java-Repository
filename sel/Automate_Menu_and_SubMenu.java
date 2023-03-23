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

public class Automate_Menu_and_SubMenu 
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
	driver.get("https://www.amazon.com/");
	}

	@Test
	public void Execute()
	{
	SubMenuAction();
	}

	private static void SubMenuAction()
	{
	//identify menu
	WebElement n=driver.findElement(By.id("nav-link-accountList"));

	//
	Actions a = new Actions(driver);
	a.moveToElement(n).perform();

	//identify sub-menu element
	WebElement m=driver.
	findElement(By.xpath("//*[text()='Create a List']"));

	//move to element and click
	a.moveToElement(m).click().perform();
	// Returning the Title of the page from the clicked icon in the Selected Submenu
	System.out.println("Page navigated to: " +driver.getTitle());
	}

	@AfterClass
	public static void CloseBrowser()
	{
	driver.quit();
	}


}
