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
import ExcelReadAndWrite.ExcelRead;

public class DataDrivenUsingExcel 
{
	public static WebDriver driver;

	@BeforeClass
	public static void BrowserLaunch() throws IOException
	{

	ExcelRead.Read("C:\\Users\\Desktop\\Deepak\\BrowserData.xlsx");
	String UserName = ExcelRead.getData.get(1)[0].toString();
	String Password = ExcelRead.getData.get(1)[1].toString();

	if (BrowserName.equalsIgnoreCase("Chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	}
	else
	{
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	}

	// url
	driver.get("https://practicetestautomation.com/practice-test-login/");

	// finding web element for username and passing the username
	WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
	element.sendKeys(UserName);

	// finding web element for password and passing the password
	WebElement ele = driver.findElement(By.xpath("//input[@id='password']"));
	ele.sendKeys(Password);

	// finding web element to perform submit through mouse hover action
	WebElement elem = driver.findElement(By.xpath("//button[@id='submit']"));
	Actions act = new Actions(driver);
	act.moveToElement(elem).click().build().perform();

	}
}
