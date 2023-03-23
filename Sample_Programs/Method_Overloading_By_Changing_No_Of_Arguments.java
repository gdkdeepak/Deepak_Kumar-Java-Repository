package Sample_Programs;

public class Method_Overloading_By_Changing_No_Of_Arguments 
{
	// Method_Overloading_By_Changing_No_oF_Arguments

	void Method(String a)		// method with 1 string datatype argument
	{
	System.out.println("Method Overloading with 1 string argument, s1 : "+a);
	}

	void Method(String s, String b)	// method with 2 STRING datatype arguments
	{
	System.out.println("Method Overloading with 2 String arguments, s1+s2 : "+(s+b));
	}


	public static void main(String[] args)
	{
	Method_Overloading_By_Changing_No_Of_Arguments i = new Method_Overloading_By_Changing_No_Of_Arguments();

	i.Method("Deepak");
	i.Method("Deepak","Kumar");
	}
}
