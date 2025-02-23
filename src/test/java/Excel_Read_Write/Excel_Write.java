package Excel_Read_Write;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel_Write 
{
	void ExcelWrite1() throws IOException
	
	{
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\Excel_Read_Write\\ExcelWrite1.xlsx");
		
		FileInputStream file = new FileInputStream(f);
		
		XSSFWorkbook w = new XSSFWorkbook(file);
		
		XSSFSheet s = w.createSheet("EmployeeDetails2");
		
		XSSFRow r = s.createRow(0);
		 
		// 0th row
		XSSFCell c = r.createCell(0);
		c.setCellValue("Name");
		
		c = r.createCell(1);
		c.setCellValue("Branch");
		
		c = r.createCell(2);
		c.setCellValue("Designation");
		
		// 1st row
		r = s.createRow(1);
		
		c = r.createCell(0);
		c.setCellValue("Gobi");
		
		c=r.createCell(1);
		c.setCellValue("Chennai");
		
		c=r.createCell(2);
		c.setCellValue("Manager");
		
		FileOutputStream fout = new FileOutputStream(f);
		
		w.write(fout);
		fout.close();	
		System.out.println("Sheet created successfully");

	}
	
	void ExcelWrite2() throws IOException
	{
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\Excel_Read_Write\\ExcelWrite2.xlsx");
		
		FileInputStream file = new FileInputStream(f);
		
		XSSFWorkbook w = new XSSFWorkbook();
		
		XSSFSheet s = w.createSheet("Details");
		
		XSSFRow r ;
		
		XSSFCell c;
		
		String[][] data = {{"Name","Mobile","Marks"},{"Bala","8989509898","91"},{"Deepak","9789687564","97"},{"Gobi","9789687000","99"}};
		
		for(int i=0; i<data.length; i++)
		{
			r = s.createRow(i);
			for(int j=0; j<data[i].length; j++)
			{
				c = r.createCell(j);
				String val = data[i][j];
				c.setCellValue(val);;
			}
		}
		
		FileOutputStream fout = new FileOutputStream(f);
		
		w.write(fout);
		fout.close();		
		System.out.println("Sheet created successfully");		
	}
	
	void ExcelWrite3() throws IOException
	{
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\Excel_Read_Write\\ExcelWrite3.xlsx");
		
		FileInputStream file = new FileInputStream(f);
		
		XSSFWorkbook w = new XSSFWorkbook();
		
		XSSFSheet s = w.createSheet("NewSheet3");
		
		XSSFRow r;
		
		XSSFCell c;
		
		Object[][] data = {{"Name","Mobile","Mark"},{"Bala",967782559,91},{"Sathis",54825359,97},{"Deepak",987554532,95}};
		
		for (int i=0; i<data.length; i++)
		{	
			r = s.createRow(i);
			for(int j=0; j<data[i].length; j++)
			{
				c = r.createCell(j);
				Object val  = data[i][j];
				
				if(val instanceof String)
				{
					c.setCellValue((String)val);
				}
				
				else if(val instanceof Integer)
				{
					c.setCellValue((Integer)val);
				}
				else if(val instanceof Integer)
				{
					c.setCellValue((Integer)val);
				}
				
			}
		}
		
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		fout.close();
		System.out.println("Sheet created successfully");		
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		Excel_Write a = new Excel_Write();
		
		//a.ExcelWrite1();
		//a.ExcelWrite2();
		a.ExcelWrite3();
	}

}
