package Hotel_Reservation_Project;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactIn_Automation 
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
	driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	
	//maximize the window
	driver.manage().window().maximize();

	// Enter to the Desired URL PAGE
	driver.get("https://adactinhotelapp.com/");
	}

	@Test
	public void Execute()
	{
		SignIn();
		SearchHotel();
		BookHotel();
		BookedItinerary();
		CancelBooking();
		LogOut();
		
	}

	private static void SignIn()
	{
		driver.findElement(By.xpath("//input[@type='text']")).click();
		WebElement Username = driver.findElement(By.xpath("//input[@type='text']"));
		Username.sendKeys("gdkkumar"); 
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='password']")).click();
		WebElement psswd = driver.findElement(By.xpath("//input[@type='password']"));
		psswd.sendKeys("INNOVATION");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='Submit']")).click();
		
	}
	
	private static void SearchHotel()
	{		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='location']")).click();
		driver.findElement(By.xpath("//option[@value='New York']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='hotels']")).click();
		driver.findElement(By.xpath("//option[@value='Hotel Sunshine']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='room_type']")).click();
		driver.findElement(By.xpath("//option[@value='Super Deluxe']")).click();

		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='room_nos']")).click();
		driver.findElement(By.xpath("//option[@value='2']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='adult_room']")).click();
		WebElement count = driver.findElement(By.xpath("//select[@id='adult_room']"));
		count.sendKeys("2");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='datepick_in']")).click();
		WebElement in_date = driver.findElement(By.xpath("//input[@id='datepick_in']"));
		in_date.sendKeys("15/04/2023");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='datepick_out']")).click();
		WebElement out_date = driver.findElement(By.xpath("//input[@id='datepick_out']"));
		out_date.sendKeys("16/04/2023");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='Submit']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='radiobutton_0']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
			
	}
	
	private static void BookHotel()
	{
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='first_name']")).click();
		WebElement f_name = driver.findElement(By.xpath("//input[@id='first_name']"));
		f_name.sendKeys("Deepak");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='last_name']")).click();
		WebElement l_name = driver.findElement(By.xpath("//input[@id='last_name']"));
		l_name.sendKeys("Kumar");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='book_now']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@id='address']")).click();
		WebElement address = driver.findElement(By.xpath("//textarea[@id='address']"));
		address.sendKeys("No.1/245, Kambar Street, Saidapet, Chennai, India - 600125");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='cc_num']")).click();
		WebElement card_no = driver.findElement(By.xpath("//input[@id='cc_num']"));
		card_no.sendKeys("7894561235791536");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='cc_type']")).click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//option[@value='MAST']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='cc_exp_month']")).click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//option[@value='9']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@id='cc_exp_year']")).click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//option[@value='2022']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='cc_cvv']")).click();
		WebElement cvv = driver.findElement(By.xpath("//input[@id='cc_cvv']"));
		cvv.sendKeys("789");
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='book_now']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,350)", "");
		
	}
	
	private static void BookedItinerary()
	{
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='my_itinerary']")).click();
		
	}
	
	private static void CancelBooking()
	{
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='check_all']")).click();
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Cancel Selected']")).click();
		driver.switchTo().alert().accept();
				
	}
	
	private static void LogOut()
	{
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='logout']")).click();
		
	}


}
