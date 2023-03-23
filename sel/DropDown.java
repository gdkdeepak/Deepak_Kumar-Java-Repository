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

public class DropDown 
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
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@Test
	public void Execute()
	{
	DropDownAction();
	}

	private static void DropDownAction()
	{
	WebElement element = driver.findElement(By.id("dropdown-class-example"));
	Select driverelement = new Select(element);

	//by index
	driverelement.selectByIndex(2);

	//by value
	driverelement.selectByValue("option3");

	//by visible text
	driverelement.selectByVisibleText("Select");

	}

	@AfterClass
	public static void CloseBrowser()
	{
	driver.quit();
	}
}
