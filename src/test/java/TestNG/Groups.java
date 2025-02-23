package TestNG;

import org.testng.annotations.Test;

public class Groups 
{
	@Test(groups = {"third party","smoke","sanity"}/*, priority = 4*/)
	//@Test
	public void PaymentProceed()
	{
		System.out.println("PaymentProceed ");
	}
	
	@Test(groups = {"smoke"}/*, priority = -1*/)
	public void SignUp()
	{
		System.out.println("Sign Up");
	}

	@Test(groups = {"smoke"}/*, priority = 4*/)
	public void SignOut()
	{
		System.out.println("Sign Out ");
	}
	
	@Test(groups = {"sanity"}/*, priority = 1*/)
	public void Login()
	{
		System.out.println("Login");
	}
	
	@Test(groups = {"sanity"}/*, priority = 3*/)
	public void addToCartt()
	{
		System.out.println("addToCart ");
	}
	
	@Test(groups = {"sanity"}/*, priority = 2*/)
	public void SearchProduct()
	{
		System.out.println("SearchProduct");
	}
	

}
