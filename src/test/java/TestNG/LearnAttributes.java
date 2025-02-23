package TestNG;

import java.util.NoSuchElementException;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.testng.annotations.Test;

public class LearnAttributes 
{
	// enabled = false ==> it wont consider it as a test case at all, (wont run)
	// enabled has higher priority than alwaysRun when given both
	@Test( enabled = false ) // wont be counted as a test at all 
	public void SignUp()
	{
		System.out.println("Sign Up");
	}
	
	@Test(description = " Login Method ", invocationCount = 1) 
	public void Login()
	{
		System.out.println("Login");
		throw new NoSuchElementException("Element not there"); // failed test
	}
	
	@Test(dependsOnMethods = "TestNG.LearnAttributes.Login" , alwaysRun = true)
	public void SearchProduct()		// avoids skipping this test method bcaz of depended method's failure
	{
		System.out.println("SearchProduct");
	}

	@Test(invocationCount = 0, alwaysRun = true )
	public void SignOut()	// invocationCount=0 supresses alwaysRun=true, it wont be counted as a test at all
	{
		System.out.println("Sign Out ");
	}
	
	@Test(alwaysRun = true, enabled = false)
	public void Pay()	// enabled=false suppresses alwaysRun=true, it wont be counted as a test at all
	{
		System.out.println("Pay");
	}
}
	/*

	NOTE :

	1) alwaysRun = true ==> test case method will run for sure 
	2) enabled = false ==> test case method wont run, it specifies that particular test case to not run at all.  
	3) description = "Comments" ,Gets printed in the report as well
	
	*/