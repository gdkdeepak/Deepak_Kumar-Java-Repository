package LetsCodeIn_Project;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automate_LetsCodeIn 
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
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	//maximize the window
	driver.manage().window().maximize();

	// Enter to the Desired URL PAGE
	driver.get("https://letcode.in/test");
	}

	@Test
	public void Execute()
	{
		//Input();
		//Button();
		//Select();
		//Alert();
		//RadioButton();
		MultiSelect();
		MultiWindow();
		Frames();
		Drag_and_Drop();

	}
	
	private static void Drag_and_Drop()
	{
		// Load URL
		driver.findElement(By.xpath("//a[@href='/dropable']")).click();
		
		// Source
		driver.switchTo().frame(0);
		driver.findElement(By.id(""));
		
		
	}
	
	private static void Frames()
	{
		
	}
	
	private static void MultiWindow()
	{
		
	}
	
	private static void MultiSelect()
	{
		
	}
	
	private static void RadioButton()
	{
		// Load URL
		driver.findElement(By.xpath("//a[@href='/radio']")).click();
		
		// slect YES
		driver.findElement(By.id("yes")).click();
		
		// Select both Yes and NO, last selected prevails
		driver.findElement(By.id("one")).click();
		System.out.println("one radio button selectable is "+driver.findElement(By.id("one")).isEnabled());		
		System.out.println("one radio button selected is "+driver.findElement(By.id("one")).isSelected());
		driver.findElement(By.id("two")).click();
		System.out.println("two radio button selected is "+driver.findElement(By.id("two")).isSelected());
		System.out.println();

		driver.findElement(By.id("nobug")).click();
		driver.findElement(By.id("bug")).click();
		
		System.out.println("Bar selectable is "+driver.findElement(By.id("notfoo")).isEnabled());
		driver.findElement(By.id("notfoo")).click();
		System.out.println("Bar selected is "+driver.findElement(By.id("notfoo")).isSelected());	
		System.out.println();
		
		driver.findElement(By.id("going")).click();
		System.out.println("MayBe selectable is "+driver.findElement(By.id("maybe")).isEnabled());		
		System.out.println("Maybe selected is "+driver.findElement(By.id("maybe")).isSelected());		
		System.out.println();
		
	
		
		/*
		 * NOTE :
		 * 1) isEnabled()
		 * 2) isSelected()
		 *
		 * 
		 */

		

		
	}
	
	private static void Alert()
	{
		// Load URL
		driver.findElement(By.xpath("//a[@href='/alert']")).click();

		// SIMPLE ALERT & print the alert message
		driver.findElement(By.id("accept")).click();
		// To simply accept alert  
		//driver.switchTo().alert().accept();
		Alert alert = driver.switchTo().alert();
		System.out.println("SIMPLE ALERT MSG ==> "+alert.getText());
		alert.accept();
		// alert.dismiss();  ==> for simple alert only one choice available, but back operations will change
		
		//NO ALERT PRESENT EXCEPTION
		//driver.switchTo().alert().accept();
		
		// CONFIRM ALERT & print alert message
		driver.findElement(By.id("confirm")).click();
		// UNHANDLED ALERT EXCEPTION 
		//driver.getCurrentUrl();
		System.out.println("CONFIRM ALERT MSG ==> "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();  
		
		// PROMPT ALERT 
		driver.findElement(By.id("prompt")).click();
		System.out.println("PROMPT ALERT MSG ==> "+driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("DEEPAK KUMAR");
		driver.switchTo().alert().accept();
		String Str = driver.findElement(By.id("myName")).getText();
		System.out.println("After PROMT ALERT, Displayed text ==> "+Str);
		
		// MODERN ALERT
		driver.findElement(By.id("modern")).click();
		System.out.println(driver.findElement(By.className("title")).getText());
		driver.findElement(By.xpath("//button[.='']")).click();
		
		/* NOTES :
		 * 
		 * only 3 types of Alert => Simple Prompt/OK alert, Confirm Ok/Cancel alert, Type text in Alert
		 * Sometimes username and password are shown if forms of alert, it is not alert
		 * It is WINDOW AUTHENTICATION 
		 * SWEET ALERT / MODERN ALERT => not at all an alert. just an web element
		 * 
		 * driver().switchTo().alert() 
		 * 		==> only 4 functions in Alert
		 * 				1) accept()
		 * 				2) dismiss()
		 * 				3) getText()
		 * 				4) sendKeys(String)
		 * 
		 * Exceptions :
		 * 1) NoAlertException
		 * 2) UnhandledAlertException
		 * 
		 */
	}
	
	private static void Select()
	{
		// Load URL
		driver.findElement(By.xpath("//a[@href='/dropdowns']")).click();
		
		// select by Visible Text
		WebElement Fruits = driver.findElement(By.cssSelector("#fruits"));
		Select frt = new Select(Fruits);
		frt.selectByVisibleText("Apple");
		System.out.println(frt.getFirstSelectedOption().getText());
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		frt.selectByVisibleText("Banana");
		System.out.println(frt.getFirstSelectedOption().getText());
		System.out.println("Multiple Select for fruits is "+frt.isMultiple());
		System.out.println();
		List<WebElement> allFruits = frt.getOptions();
		allFruits.forEach(i -> System.out.println(i.getText()));
		System.out.println();
		
		// select by value
		WebElement Country = driver.findElement(By.cssSelector("#country"));
		Select cntry = new Select(Country);
		System.out.println("Multiple Select for Country is "+cntry.isMultiple());
		cntry.selectByValue("Argentina");
		System.out.println(cntry.getFirstSelectedOption().getText());
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		cntry.selectByValue("Suriname");
		System.out.println(cntry.getFirstSelectedOption().getText());
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
		cntry.selectByValue("India");
		System.out.println(cntry.getFirstSelectedOption().getText());
		// Cant use deselect in single select drop down
		// UNSUPPORTED OPERATION EXCEPTION
		// cntry.deselectByValue("Suriname"); 
		System.out.println();
		
		// select multiple SuperHeroes
		WebElement Multi  = driver.findElement(By.id("superheros"));
		Select heros = new Select(Multi);
		System.out.println();
		List<WebElement> allHeroes = heros.getOptions();
		allHeroes.forEach(i -> System.out.println(i.getText()));
		System.out.println();
		System.out.println("Multiple Select for Heroes is "+heros.isMultiple());
		heros.selectByIndex(1);
		heros.selectByValue("bt");
		heros.selectByValue("ta");
		heros.selectByValue("bw");
		heros.selectByVisibleText("Thor");
		System.out.println("Selected Heroes before Deselect :");
		List<WebElement> Heros = heros.getAllSelectedOptions();
		for(WebElement we : Heros)
		{
			System.out.println(we.getText());
		}
		System.out.println();
		heros.deselectByIndex(2);
		heros.deselectByIndex(0);
		heros.deselectByValue("bt");
		heros.deselectByVisibleText("Thor");
		System.out.println("Selected Heroes after Deselect :");
		List<WebElement> Heroes = heros.getAllSelectedOptions();
		for(WebElement we : Heroes)
		{
			System.out.println(we.getText());
		}
		System.out.println();
		
		// Select the Last Option Programming Language
		Select ProLang = new Select(driver.findElement(By.id("lang")));		
		ProLang.selectByIndex(4);
		System.out.println("Multiple Select for Programming Language is "+ProLang.isMultiple());
		System.out.println(ProLang.getFirstSelectedOption().getText());
		
		/*
		 * NOTES:
		 * 
		 * 1) selectByVisibleText(String)
		 * 2) selectByValue(String)
		 * 3) selectByIndex(int)
		 * 4) getFirstSelectedOption().getText()
		 * 5) Multiple dropdown select is present means,
		 * 			==> Select_Variable.isMultiple() = true
		 * 6) deselectByIndex(int)
		 * 7) deselectByValue(String)
		 * 8) deselectByVisibleText(String)
		 * 9) getOptions()
		 * 10)getAllSelectedOptions()
		 * 
		 * EXCEPTIONS :
		 * 
		 * 1)UnSupportedOperationException
		 * 
		 */
		
	}

	private static void Button()
	{
		// Load URL
		driver.findElement(By.xpath("//a[@href='/buttons']")).click();

		// Find X & Y Co-ordinates &  dimensions of button
		System.out.println("Button : 'Find Location'");
		Point pt = driver.findElement(By.id("position")).getLocation();
		int x = pt.getX();
		int y = pt.getY();
		System.out.println();
		System.out.println("Points :  X => "+x+"  Y => "+y);
		System.out.println("Size => "+driver.findElement(By.id("position")).getSize());
		System.out.println("Location => "+driver.findElement(By.id("position")).getLocation());
		System.out.println("Rect Dimensions => "+driver.findElement(By.id("position")).getRect().getDimension());
		System.out.println("Rect Height => "+driver.findElement(By.id("position")).getRect().getHeight());
		System.out.println("Rect Width => "+driver.findElement(By.id("position")).getRect().getWidth());
		System.out.println("Rect Points => "+driver.findElement(By.id("position")).getRect().getPoint());
		System.out.println("Rect X => "+driver.findElement(By.id("position")).getRect().getX());
		System.out.println("Rect Y => "+driver.findElement(By.id("position")).getRect().getY());
		System.out.println();
		
		// Find the Color of the Button 'What is my Colour'
		System.out.println("Button : 'What is my Colour'");
		WebElement BtnColor = driver.findElement(By.id("color"));
		String BackGrndColor = BtnColor.getCssValue("background-color");
		String BorderColor = BtnColor.getCssValue("border-color");
		String TextColor = BtnColor.getCssValue("color");
		System.out.println("ButtonBox BackGround color : "+BackGrndColor);
		System.out.println("ButtonBox Border color : "+BorderColor);
		System.out.println("ButtonBox Text color : "+TextColor);
		System.out.println();
		
		// Find the Color of GotoHome Button
		System.out.println("Button : 'GotoHome'");
		WebElement GoHomeBtn = driver.findElement(By.id("home"));
		String BackGrndColor1 = GoHomeBtn.getCssValue("background-color");
		String BorderColor1 = GoHomeBtn.getCssValue("border-color");
		String TextColor1 = GoHomeBtn.getCssValue("color");
		System.out.println("ButtonBox BackGround color : "+BackGrndColor1);
		System.out.println("ButtonBox Border color : "+BorderColor1);
		System.out.println("ButtonBox Text color : "+TextColor1);
		System.out.println();
		
		// Find the Height and Width of the Button
		System.out.println("Button : 'How tall & fat I am?'");
		Rectangle rect = driver.findElement(By.id("property")).getRect();
		System.out.println("Location of button => "+rect.getPoint());
		Dimension dim = rect.getDimension();
		System.out.println("Size of the button => "+dim);
		System.out.println("Height of the button => "+dim.getHeight());
		System.out.println("Width of the button => "+dim.getWidth());
		System.out.println();
		
		// Check whether Confirm Button Disabled or not
		System.out.println("Button : 'Disabled'");
		System.out.println("Button Dimension => "+driver.findElement(By.id("isDisabled")).getRect().getDimension());
		System.out.println("Button Location => "+driver.findElement(By.id("isDisabled")).getRect().getPoint());
		System.out.println("Button Size => "+driver.findElement(By.id("isDisabled")).getSize());
		boolean Confrmbtn = driver.findElement(By.id("isDisabled")).isEnabled();
		System.out.println("Confirm Button Enabled is => "+Confrmbtn);
		
		// Click and hold a button
		Actions actions = new Actions(driver); 
		actions.moveToElement(driver.findElement(By.xpath("//button[.='Button Hold!']"))); 
		actions.clickAndHold().perform(); 
	
		/*
		 * NOTES :
		 * 1) getLocation()  =>  returns Location points
		 * 			a)  getX()
		 * 			b)  getY()
		 * 2) getSize() => returns the size
		 * 3) getRect()
		 * 			i)   getDimension() - returns the height and width of the rect  box
		 * 					a) getHeight()
		 * 					b) getWidth()
		 * 			ii)  getPoint() => returns location points 
		 * 			iii) getX() => returns x-point location
		 * 			iv)  getY() => returns y-point location
		 * 4)getCssValue(propertyName)
		 * 5) Button is Enabled  ==> isEnabled() = true 
		 * 	  Button is Disabled ==> isEnabled() = false
		 * 6) action_Variable.moveToElement(WebElement)
		 * 7) action_Variable.clickAndHold().perform()
		 * 
		 */
	}
	private static void Input()
	{
		// Go to Edit Input URL Page
		driver.findElement(By.xpath("//a[@href='/edit']")).click();
		
		// Enter into TextBox 
		driver.findElement(By.id("fullName")).sendKeys("Deepak Kumar");
		
		// Append a text into a TextBox
		driver.findElement(By.id("join")).sendKeys(" living being", Keys.TAB);
		
		// Get the text value from a TextBox
		String Value=driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println(Value);
		System.out.println();
		
		// Clear the Text in a TextBox
		driver.findElement(By.id("clearMe")).clear();
		
		// Whether the text box is  displayed and disabled to edit
		boolean isVisible = driver.findElement(By.id("noEdit")).isDisplayed();
		boolean isEnabled = driver.findElement(By.id("noEdit")).isEnabled();
		System.out.println(isVisible);
		System.out.println(isEnabled);
		String RO = driver.findElement(By.id("noEdit")).getAttribute("readonly");
		System.out.println(RO);
		System.out.println();

		// Confirm text is Displayed and ReadOnly
		boolean isVisible2 = driver.findElement(By.id("dontwrite")).isDisplayed();
		System.out.println(isVisible2);
		boolean isEnabled2 = driver.findElement(By.id("dontwrite")).isEnabled();
		System.out.println(isEnabled2);
		String RO2 = driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println(RO2);
	
		/*
		 * NOTES :
		 * 1)sendKeys(String)
		 * 2)sendKeys(Keys.TAB)
		 * 3)getAttribute(attribute_name)
		 * 4)clear()
		 * 5)isDisplayed()
		 * 6)isEnabled()
		 * 
		 * Edit Disabled => Cant even copy the text in the webPage
		 *   => isEnabled() = false , isDisplayed() = true , readonly class is absent(null)
		 * TextBox is ReadOnly => can only copy the text , but cant change the text
		 *   => isEnabled() = true , isDisplayed() = true , readonly class is present(true)
		 * 
		 */
	}
	
}
