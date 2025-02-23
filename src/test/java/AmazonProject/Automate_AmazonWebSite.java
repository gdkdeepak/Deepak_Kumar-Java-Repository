package AmazonProject;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_AmazonWebSite 
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
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	
	//maximize the window
	driver.manage().window().maximize();

	// Enter to the Desired URL PAGE
	driver.get("https://www.amazon.com/");
	}

	@Test
	public void Execute()
	{
	SignIn();
	Purchase();
	//RemoveFromCart();
	//LogOut();
	}

	private static void SignIn()
	{
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	driver.findElement(By.id("nav-link-accountList")).click();
	  	
	String Mobile = "9790967200";
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	WebElement UserID = driver.findElement(By.xpath("//input[@id='ap_email']"));
	
	UserID.sendKeys(Mobile);
	UserID.sendKeys(Keys.ENTER);
	
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	String Password = "amazonautomation";
	WebElement psswd = driver.findElement(By.xpath("//input[@id='ap_password']"));
	
	psswd.sendKeys(Password);
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	psswd.sendKeys(Keys.ENTER);
				
	}
	
	private static void Purchase()
	{
	// find the web elemnet of search box
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	WebElement searchbox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	
	// Click the search box
	Actions action = new Actions(driver);
	action.moveToElement(searchbox).click().perform();
	
	// Entering the item to be searched
	String s = "Samsung Galaxy S23";
	searchbox.sendKeys(s);
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)", "");
	
	// Select the item
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	driver.findElement(By.linkText("SAMSUNG Galaxy S23 Cell Phone, Factory Unlocked Android Smartphone, 256GB Storage, 50MP Camera, Night Mode, Long Battery Life, Adaptive Display, US Version, 2023, Lavender")).click();

	Select qty = new Select(driver.findElement(By.name("quantity")));
	String st = "2";
	qty.selectByValue(st);	
	
	// Add item to cart
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

	// Proceed to checkout
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

	// Confirm Purchase
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();

	System.out.println("Product is successfully purchased");
	
	}
	
	private static void RemoveFromCart()
	{
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Delete']")).click();

	}
	
	private static void LogOut()
	{
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.linkText("Sign Out")).click();		
	}

	//@AfterClass
	public static void CloseBrowser()
	{
	driver.quit();
	}



}
