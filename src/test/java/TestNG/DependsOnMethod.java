package TestNG;

import org.testng.annotations.Test;

public class DependsOnMethod 
{
	@Test(dependsOnMethods = {"addToCart"})
	public void PaymentProceed()
	{
		System.out.println("PaymentProceed ");
		throw new RuntimeException();  
	}
	
	@Test(priority = 1)
	public void SignUp()
	{
		System.out.println("Sign Up");
	}

	@Test (dependsOnMethods = "SignUp", priority = -1)
	// if both given TestNG will give more priority to depandsOnMethods
	// dependsOnMethods supresses Priority when given both in a @Test
	public void Login()
	{
		System.out.println("Login");
	}
	
	@Test(dependsOnMethods = {"PaymentProceed","Login"} , priority = -4)
	public void SignOut()
	{
		System.out.println("Sign Out ");
	}
	
	@Test(dependsOnMethods = "SearchProduct")
	public void addToCart()
	{
		System.out.println("addToCart ");
	}
	
	@Test(dependsOnMethods = "Login")
	public void SearchProduct()
	{
		System.out.println("SearchProduct");
	}

}
