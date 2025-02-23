package NewSeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenFile 
{
	public void Op_File()
	{
	WebDriver driver = new ChromeDriver();
	String path = this.getClass().getResource("/Openfile.txt").getPath();
	driver.get("file://" +path);
	driver.findElement(By.id("button")).click();
	}
}
