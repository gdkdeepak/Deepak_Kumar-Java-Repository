package PractiseFormFilling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataRead 
{

	public static String[][] FormData() throws IOException 
	{
	File f = new File("C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumProject\\PractiseForm\\FormData.xlsx");
	FileInputStream fin = new FileInputStream(f);
	XSSFWorkbook w = new XSSFWorkbook(fin);
	XSSFSheet s = w.getSheetAt(0);
	int LastRowNum = s.getLastRowNum();
	int LastCellNum = s.getRow(0).getLastCellNum();
	String[][] data = new String[LastRowNum][LastCellNum];
	for (int i = 1; i <= LastRowNum; i++)
	{
		XSSFRow r = s.getRow(i);
		for (int j = 0; j < LastCellNum; j++)
		{
			XSSFCell c = r.getCell(j);
			DataFormatter dft = new DataFormatter();
			String val = dft.formatCellValue(c);	
			data[i-1][j] = val;
		} 
	}
	
	w.close();
	
	return data;
		
	}
}
