package PractiseFormFilling;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class GiveData 
{
	@DataProvider( parallel = true )	// without using name field
	public static String[][] getData() throws IOException 
	{
		String[][] DATA = ExcelDataRead.FormData();
		return DATA;
	}

}
