package Sample_Programs;

public class Method_Overloading_By_Changing_Datatype
{
	// Method_Overloading_By_Changing_Datatype

	void Method(int a)		// method with INT datatype
	{
	System.out.println("Method Overloading with int datatype value : "+a);
	}

	void Method(String s)	// method with STRING datatype
	{
	System.out.println("Method Overloading with String datatype entry : "+s);
	}

	public static void main(String[] args)
	{
	Method_Overloading_By_Changing_Datatype i = new Method_Overloading_By_Changing_Datatype();
	i.Method(50);
	i.Method("CodeRed");
	}

	
}
