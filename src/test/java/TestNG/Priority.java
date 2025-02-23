package TestNG;

import org.testng.annotations.Test;


// Default Test cases RUN based on ASCII order if not given any order or priority
// @Test = ANNOTATION
// Priority = ATTRIBUTE (it can even be set to negative value, it will execute as like in graph order)
//  ... -infinite, ..., -2, -1, 0, 1, 2, ... +infinite ...

public class Priority 
{
	@Test(priority = 5)
	public void PaymentProceed()
	{
		System.out.println("PaymentProceed ");
	}
	
	@Test(priority = -1)
	public void SignUp()
	{
		System.out.println("Sign Up");
	}

	@Test(priority = 6)
	public void SignOut()
	{
		System.out.println("Sign Out ");
	}
	
	@Test  // defaultly set to priority 0 if not assigned priority
	public void Login()
	{
		System.out.println("Login");
	}
	
	@Test(priority = 4)
	public void addToCart()
	{
		System.out.println("addToCart ");
	}
	
	@Test(priority = 3)
	public void SearchProduct()
	{
		System.out.println("SearchProduct");
	}
	
}
