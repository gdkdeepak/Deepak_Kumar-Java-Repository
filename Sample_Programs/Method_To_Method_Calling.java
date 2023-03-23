package Sample_Programs;

public class Method_To_Method_Calling 
{
	void Method1()
	{
	System.out.println(" Method 1 called successfully ");
	}

	void Method2()
	{
	// Method-to-Method calling
	Method1();			// We can directly call the method name
	System.out.println(" Method 2 called successfully ");
	}

	public static void main(String[] args)
	{
	Method_To_Method_Calling m = new Method_To_Method_Calling();
	m.Method1();
	m.Method2();
	}
}
