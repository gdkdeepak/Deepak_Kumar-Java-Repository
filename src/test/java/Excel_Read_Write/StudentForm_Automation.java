package Excel_Read_Write;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StudentForm_Automation 
{
	public static WebDriver driver;
	
    public static  void main(String args[]) throws IOException 
    {
    	WebDriverManager.chromedriver().setup();
      	System.out.println("Driver Path : "+System.getProperty("webdriver.chrome.driver"));
      	    	
        //Create an object of File class to open Excel file
        File file =    new File("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\Excel_Read_Write\\StudentFormDetail.xlsx");
        
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);
        
        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        
        //creating a Sheet object
        XSSFSheet sheet = wb.getSheetAt(0);
        
        //get all rows in the sheet
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        
       //Creating an object of ChromeDriver
        driver = new ChromeDriver();
        
        // Implicit Wait 
    	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
    	
    	//maximize the window
    	driver.manage().window().maximize();
        
        //Navigate to the URL
        driver.get("https://demoqa.com/automation-practice-form");

        //Identify the WebElements for the student registration form
        //Enter the values read from Excel file into Student Form text box
        
        // Student First Name
        WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
        
        // Student Last Name
        WebElement lastName=driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
        
        // Student Email
        WebElement email=driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
        
        //Click on the gender radio button using javascript
        WebElement genderMale= driver.findElement(By.xpath("//input[@value='Male']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",genderMale);
       
        // Student Contact Number
        WebElement mobile=driver.findElement(By.xpath("//input[@id='userNumber']"));
        
        XSSFRow r = sheet.getRow(1);
        XSSFCell c = r.getCell(3);
        DataFormatter df = new DataFormatter();	
		String phn = df.formatCellValue(c);
        mobile.sendKeys(phn);
        
        // Select D.O.B
        driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
        driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")).click();
        driver.findElement(By.xpath("//option[@value='1997']")).click();
        driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")).click();
        driver.findElement(By.xpath("//option[@value='5']")).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--005']")).click();       
        
        JavascriptExecutor jsp = (JavascriptExecutor) driver;
    	jsp.executeScript("window.scrollBy(0,350)", "");
    	
        // Student Subject
        WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        subject.sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
        subject.sendKeys(Keys.ENTER);
        
        // Select check box READING
    	driver.findElement(By.xpath("//label[text()='Sports']")).click();
    	driver.findElement(By.xpath("//label[text()='Music']")).click();
    	
        // Student Address
        WebElement address=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());
      
        // Upload picture
        WebElement element = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
    	element.sendKeys("C:\\Users\\ADMIN\\Desktop\\Deepak.jpg");
    	System.out.println("Picture Uploaded Successfully");
    	
    	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
    	    	
    	// Select State
    	WebElement State = driver.findElement(By.xpath("//div[text()='Select State']"));
    	State.sendKeys(sheet.getRow(1).getCell(6).getStringCellValue());
    	State.sendKeys(Keys.ENTER);

    	// Select city 
    	WebElement city = driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder'][2]"));
    	city.sendKeys(sheet.getRow(1).getCell(7).getStringCellValue());
    	city.sendKeys(Keys.ENTER);
    	
    	driver.findElement(By.xpath("//button[@id='submit']")).click();
    	

       /*
           
       //Verify the confirmation message
       WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));
            
       //create a new cell in the row at index 6
       XSSFCell cell = sheet.getRow(2).createCell(0);
            
       //check if confirmation message is displayed
       if (confirmationMessage.isDisplayed()) 
       {
       		// if the message is displayed , write PASS in the excel sheet
            cell.setCellValue("Student Form Filled successfully");         
       } 
       else 
       {
           //if the message is not displayed , write FAIL in the excel sheet
           cell.setCellValue("Student Form Filling Failed");
       }
            
       // Write the data back in the Excel file
       FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\Excel_Read_Write\\StudentFormDetail.xlsx");
       wb.write(outputStream);

       //close the confirmation popup
       WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
       closebtn.click();
            
       //wait for page to come back to registration page after close button is clicked
       driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
      
        */
        
        //Close the workbook
        wb.close();
        
      
        }
}
