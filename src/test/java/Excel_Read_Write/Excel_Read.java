package Excel_Read_Write;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read 
{
	//  TYPE 1
	void ExcelRead1() throws IOException				
	{
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\Excel_Read_Write\\Basic_Details.xlsx");
		FileInputStream fin = new FileInputStream(f);
		
		XSSFWorkbook w = new XSSFWorkbook(fin);
	
		System.out.println("*********** DATA IN SHEET-0 **************  ");
		System.out.println();
		XSSFSheet s = w.getSheetAt(0);
		
		// TO FIND THE TOTAL NO. OF ROWS IN A PARTICULAR SHEET
		int Total_rows = s.getLastRowNum()+1;
		System.out.println(" Total no. of rows in sheet-0 ==> "+Total_rows);
		
		
		// 0th ROW
		XSSFRow r = s.getRow(0);
		
		// TO FIND THE TOTAL NO. OF CELLS IN A PARTICULAR ROW
		int total_cells = r.getLastCellNum();
		System.out.println(" Total no. of cells in row-0 in sheet-0 ==> "+total_cells);
		System.out.println();
		
		XSSFCell c = r.getCell(0);
		String t1 = c.getStringCellValue();
		System.out.print(t1);
		
		c=r.getCell(1);
		String t2 = c.getStringCellValue();
		System.out.print("	"+t2);
		
		c=r.getCell(2);
		String t3 = c.getStringCellValue();
		System.out.print("	"+t3);
		
		c=r.getCell(3);
		String t4 = c.getStringCellValue();
		System.out.print("	"+t4);
		
		c=r.getCell(4);
		String t5 = c.getStringCellValue();
		System.out.print("	"+t5);
		

		c=r.getCell(5);
		String t6 = c.getStringCellValue();
		System.out.println("	"+t6);
				
		// 1st ROW
		r = s.getRow(1);
		
		c = r.getCell(0);
		String u1 = c.getStringCellValue();
		System.out.print(u1);
		
		c=r.getCell(1);
		String u2 = c.getStringCellValue();
		System.out.print("	"+u2);
		
		c=r.getCell(2);
		String u3 = c.getStringCellValue();
		System.out.print("	"+u3);
		
		c = r.getCell(3);
		// Data formatter allows all types of data to be stored in itself
		DataFormatter df = new DataFormatter();	
		String u4 = df.formatCellValue(c);
		System.out.print("  "+u4);
		
		c=r.getCell(4);
		String u5 = c.getStringCellValue();
		System.out.print("	"+u5);
		
		c=r.getCell(5);
		// to get date cell value
		java.util.Date u6 = c.getDateCellValue();		
		SimpleDateFormat jk = new SimpleDateFormat("dd-MM-YYYY");
		String form1=jk.format(u6);
		System.out.println("	"+form1);
		
		// 2nd ROW
		r = s.getRow(2);
		
		c = r.getCell(0);
		String v1 = c.getStringCellValue();
		System.out.print(v1);
		
		c=r.getCell(1);
		String v2 = c.getStringCellValue();
		System.out.print("	"+v2);
		
		c=r.getCell(2);
		String v3 = c.getStringCellValue();
		System.out.print("	"+v3);
		
		c = r.getCell(3);
		DataFormatter df1 = new DataFormatter();
		String v4 = df1.formatCellValue(c);		
		System.out.print("  "+v4);
		
		c=r.getCell(4);
		String v5 = c.getStringCellValue();
		System.out.print("	"+v5);
		
		c=r.getCell(5);
		// to get date cell value
		java.util.Date v6 = c.getDateCellValue();		
		SimpleDateFormat jk1 = new SimpleDateFormat("dd-MM-YYYY");
		String form2=jk1.format(v6);
		System.out.println("	"+form2);
		
		fin.close();
		System.out.println();
		
		// SIMILARLY FOR SUBSEQUENT ROWS...........
		// 3rd ROW...
		// 4th ROW...
	}
	
	//  TYPE 2	
	void ExcelRead2(String filepath) throws IOException			
	{
		File f = new File(filepath);
		FileInputStream fin = new FileInputStream(f);
		
		XSSFWorkbook w = new XSSFWorkbook(fin);
	
		XSSFSheet sheet = w.getSheetAt(0);
		
		XSSFRow r;
		
		XSSFCell c;
		
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	        
	    //iterate over all the row to print the data present in each cell.
	    for(int i=0;i<=rowCount;i++)
	    {
	    	//get cell count in a row
	    	r = sheet.getRow(i);
	    	int cellcount=r.getLastCellNum();
	            
	    	//iterate over each cell to print its value
	    	//System.out.println("\nRow-"+i+" data is :");
	        System.out.println();  
	        
	    	for(int j=0;j<cellcount;j++)
	    	{
	    	// ILLEGAL STATE EXCEPTION as follows........
	    	//	System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+" , ");
	    	
	    	c = r.getCell(j);
	    	// Data formatter allows all types of data to be stored in itself	
	    	DataFormatter df = new DataFormatter();		
			String val = df.formatCellValue(c);
	    	System.out.print(val+"   ");
	    	}	    	
	    }		
		fin.close();
	}
		
	//  TYPE 3
	public static LinkedList<Object[]> g = new LinkedList<Object[]>();
	
	void ExcelRead3(String filepath) throws IOException			
	{
		File f = new File(filepath);
		FileInputStream fin = new FileInputStream(f);
		
		XSSFWorkbook w = new XSSFWorkbook(fin);
	
		XSSFSheet s = w.getSheetAt(0);
		
		XSSFRow r;
		
		XSSFCell c;
		
		int total_rows = s.getLastRowNum();
		System.out.println(" Total no. of rows in sheet-0 ==> "+(total_rows+1));
		
		for(int i=0; i<=total_rows; i++) 
		{
			r = s.getRow(i);
			int total_cells = r.getLastCellNum();
			
			Object[] data = new Object[total_cells];
			for(int d=0; d<total_cells; d++)
			{
				c = r.getCell(d);
				DataFormatter df = new DataFormatter();			// Data formatter allows all types of data to be stored in itself
				String val = df.formatCellValue(c);		
				data[d]=val;							
			}
			g.add(data);	// Store the data in collection
		}
		fin.close();
		
		System.out.println(" File processed successfully ");
		System.out.println();
		
		System.out.println("*********** DATA IN SHEET-0 **************  ");
		System.out.println();
		
		// TO PRINT THE STORED COLLECTION DATA 
		for(Object[] a : g)
		{
			for (Object b : a)
			{
				System.out.print("   "+b);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		Excel_Read b = new Excel_Read();
		
		//b.ExcelRead1();
				
		//b.ExcelRead2("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\Excel_Read_Write\\Basic_Details.xlsx");
		
		b.ExcelRead3("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\Excel_Read_Write\\Basic_Details.xlsx");
	}
}