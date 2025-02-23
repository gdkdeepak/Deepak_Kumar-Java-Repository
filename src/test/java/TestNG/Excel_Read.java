package TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read 
{
	public static void main(String[] args) throws IOException 
	{
		File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\TestNG_Data\\Login-data.xlsx");
		FileInputStream fin = new FileInputStream(f);
		XSSFWorkbook w = new XSSFWorkbook(fin);
		XSSFSheet s = w.getSheetAt(0);
	//	int LastCellNum = s.getRow(0).getLastCellNum();  // Incase of comments excel file from 1st row, 
		for (int i = 0; i <= s.getLastRowNum(); i++)
		{
			XSSFRow r = s.getRow(i);
			for (int j = 0; j < r.getLastCellNum();j++) // REPLACE r.getLastCellNum -->  LastCellNum
			{
				XSSFCell c = r.getCell(j);
				DataFormatter dft = new DataFormatter();
				String val = dft.formatCellValue(c);			
			//	String val = c.getStringCellValue();
				System.out.print(val+"			");
			} 
			System.out.println();
		}
		w.close();
		fin.close();
		
	}
}
