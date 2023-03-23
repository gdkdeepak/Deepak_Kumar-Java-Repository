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

public class Multiple_Browsers 
{
	@Test
	public void Auto_EdgeBrowser()
	{
	WebDriverManager.chromedriver().setup();
	System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
	WebDriver driver = new ChromeDriver();

	//click open window button
	driver.findElement(By.id("openwindow")).click();

	//getAll window property
	LinkedList<String> windowProperty = new LinkedList<String>();
	windowProperty.addAll(driver.getWindowHandles());
	System.out.println("size :"+windowProperty.size());

	String parentWindow = windowProperty.get(0);
	String childWindow = windowProperty.get(1);

	//childwindow
	driver.switchTo().window(childWindow);

	//parent window
	driver.switchTo().window(parentWindow);
	}

	@Test
	public void Auto_EdgeBrowser()
	{
	WebDriverManager.edgedriver().setup();
	System.out.println("Driver Path : "+System.getProperty("webdriver.edge.driver"));
	WebDriver driver = new EdgeDriver();

	//click open window button
	driver.findElement(By.id("openwindow")).click();

	//getAll window property
	LinkedList<String> windowProperty = new LinkedList<String>();
	windowProperty.addAll(driver.getWindowHandles());
	System.out.println("size :"+windowProperty.size());

	String parentWindow = windowProperty.get(0);
	String childWindow = windowProperty.get(1);

	//childwindow
	driver.switchTo().window(childWindow);

	//parent window
	driver.switchTo().window(parentWindow);
	}


}
