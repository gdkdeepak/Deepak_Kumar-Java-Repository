package LetsCodeIn_Project;


import java.io.IOException;

import org.testng.annotations.DataProvider;

import TestNG.DataProvider_Excel_Read;

public class DataGiver // this is the data supplier to TestNg package DATA PROVIDER CONCEPT topics
{
	//@DataProvider(name = "Login", indices = {1,2}, parallel = true) // using name field
	@DataProvider( parallel = true )	// without using name field
	public static String[][] getData() throws IOException 
	{
		String[][] DATA = DataProvider_Excel_Read.LoginData();
		return DATA;
		
		/*
		String[][] data = new String[3][2];
		
		data[0][0]="kowshik350@gmail.com";
		data[0][1]="Pass123$";
		
		data[1][0]="kowshik1@letcode.in";
		data[1][1]="Pass123$";
		
		data[2][0]="deekay@gmail.com";
		data[2][1]="Pas==123$";
		
		return data;
		*/
		
	}

}

/*
Notes :
	1) @DataProvider
			a) name = "String"
			b) indices = {0,1,...int}
			c) parallel = boolean
	
*/