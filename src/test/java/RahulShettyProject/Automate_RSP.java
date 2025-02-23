package RahulShettyProject;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_RSP 
{
	
	public static WebDriver driver;
	
	@BeforeClass
	public static void Launch() 
	{
		//auto
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		//maximize
		driver.manage().window().maximize();

		//url
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
	}
	
	@Test
	public void Execute() 
	{
		//TextBox();
		//ButtonAction();
		//MouseHoverAction();
		//CheckBox();
		//MultiActionCheckBox();
		//MultiActionRadioButton();
		//Alert();
		//HighlightEle();
		Scrollbar();
	}
	
	
	
	private static void Scrollbar() 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("mousehover")));
		
		//by pixel
		js.executeScript("window.scrollBy(0,200)");
		
		//by element
		WebElement ele = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView();",ele ); 
		
		//by bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); 
		
	}
	
	private static void HighlightEle() 
	{
		JavascriptExecutor jsc = (JavascriptExecutor)driver;           	
		//border line
		WebElement checkbox = driver.findElement(By.xpath("//label[@for='bmw']"));
		jsc.executeScript("arguments[0].setAttribute('style', arguments[1]);", checkbox, " border: 3px solid red;");	
	
		//background color
		WebElement textBox = driver.findElement(By.id("name"));
		jsc.executeScript("arguments[0].style.background='yellow'", textBox);
	
		//border with background color
		WebElement listbox = driver.findElement(By.id("autocomplete"));
		 jsc.executeScript("arguments[0].setAttribute('style', arguments[1]);",listbox, " border: 3px solid red;background:yellow");
	}
	
	
	private static void Alert() 
	{
		/*syntax :
		----------
			 driver.switchTo().alert().

		Action :
		----------
			ok             :  .accept();
			cancel         :  .dismiss();
			get text       :  .getText();
			Enter textbox  :  .sendKeys("userInput");*/
		
		//simple alert
		
		driver.findElement(By.id("alertbtn")).click();
		
		String getMessage = driver.switchTo().alert().getText();
		System.out.println("alert msg :"+getMessage);
		
		driver.switchTo().alert().accept();
		
	}
	
	private static void MultiActionRadioButton() 
	{
		//.click
		// checked or unchecked to find(.isSelected())
		for(int i=1; i<=3; i++) 
		{
			String locator = "//input[@value='radio"+i+"']";
			System.out.println("locator :"+locator);
			WebElement ele = driver.findElement(By.xpath(locator));
			boolean chkFlag = ele.isSelected();
			System.out.println("checkbox flag :"+chkFlag);
			if(chkFlag==false) 
			{
				ele.click();
			}
		}
	}
	
	private static void CheckBox() 
	{
		//.click
		// checked or unchecked to find(.isSelected())
		String locator = "checkBoxOption2";
		WebElement ele = driver.findElement(By.id(locator));
		boolean chkFlag = ele.isSelected();
		System.out.println("checkbox flag :"+chkFlag);
		if(chkFlag==false) 
		{
			ele.click();
		}
	}
	
	private static void MultiActionCheckBox() 
	{
		//.click
		// checked or unchecked to find(.isSelected())
		for(int i=1; i<=3; i++)
		{
			String locator = "checkBoxOption"+i;
			System.out.println("locator :"+locator);
			WebElement ele = driver.findElement(By.id(locator));
			boolean chkFlag = ele.isSelected();
			System.out.println("checkbox flag :"+chkFlag);
			if(chkFlag==false) 
			{
				ele.click();
			}
		}
	}
	
	private static void MouseHoverAction() 
	{
		//same like button action and to click hyperlink
		// this action will done by mouse
		//syntax : Actions variable = new Actions(driver);
		//         variable.moveToElement(ele).click().build().perform();
		//		   variable.moveToElement(ele).doubleclick().build().perform();	
		
		//type1
		WebElement ele = driver.findElement(By.xpath("//button[text()='Open Window']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
		
		//type2
		//Actions act1 = new Actions(driver);
		//act1.moveToElement(driver.findElement(By.xpath("//button[text()='Open Window']"))).click().build().perform();
	}
	
	private static void ButtonAction() 
	{
		
		//.click();
		//driver.findElement(By.xpath("//button[text()='Open Window']")).click();
	
		WebElement ele = driver.findElement(By.xpath("//button[text()='Open Window']"));
		ele.click();
	}
	
	private static void TextBox() 
	{
		//********************enter value************************
		//type 1
		driver.findElement(By.id("name")).sendKeys("Welcome to Selenium");
		
		//type 2
		WebElement ele = driver.findElement(By.id("name"));
		ele.sendKeys("Welcome to Selenium");
		
		//*******************Clear*******************************
		//type 1
		driver.findElement(By.id("name")).clear();
		
		//type 2
		ele.clear();
		
		//*******************get value*******************************
		driver.findElement(By.id("name")).sendKeys("Welcome to Selenium");
		
		//way :1
		String value = driver.findElement(By.id("name")).getText();
		
		//way :2
		String value2 = driver.findElement(By.id("name")).getAttribute("value");
		System.out.println("value :"+value);
		System.out.println("value2 :"+value2);
		
		//*******************tab and Enter*******************************
		WebElement ele1 = driver.findElement(By.id("name"));
		ele1.clear();
		ele1.sendKeys("Welcome to Selenium");
		ele1.sendKeys(Keys.TAB);
		ele1.sendKeys(Keys.ENTER);
		
		//*******************enable or disable*******************************
		boolean bn = ele1.isEnabled();
		System.out.println("enable flag :"+bn);
		//bn = true means "enable"
		//bn = false means "disable"
		
		//*******************visible or invisible*******************************
		boolean bn1 = ele1.isDisplayed();
		System.out.println("visible flag :"+bn1);
		//bn1 = true means "visible"
		//bn1 = false means "invisible"
				
	}

}
