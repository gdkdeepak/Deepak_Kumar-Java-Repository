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

public class Handling_MultiWindows 
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
}

@Test
public void Execute()
{
MultiwindowAction();
}


private static void MultiwindowAction()
{
//getAll window property
LinkedList<String> windowProperty = new LinkedList<String>();
windowProperty.addAll(driver.getWindowHandles());
System.out.println("size :"+windowProperty.size());

String parentWindow = windowProperty.get(0);
String childWindow = windowProperty.get(1);

//childwindow
driver.switchTo().window(childWindow);
// ... complete tasks...

//parent window
driver.switchTo().window(parentWindow);
//  ...complete tasks...

//childwindow
driver.switchTo().window(childWindow);

}

@AfterClass
public static void CloseBrowser()
{
driver.quit();
}
}

