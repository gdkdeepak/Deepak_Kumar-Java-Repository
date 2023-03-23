package Sample_Programs;

public class Constructor_Overloading 
{
	Constructor_Overloading()
	{
	System.out.println("No Argument constructor");
	}

	Constructor_Overloading(int a)
	{
	System.out.println("Parameterized constructor with Int parameter "+a);
	}

	Constructor_Overloading(String s)
	{
	System.out.println("Parameterized constructor with String parameter "+s);
	}

	public static void main(String[] args) {
		Constructor_Overloading d1 = new Constructor_Overloading();
		Constructor_Overloading d2 = new Constructor_Overloading(53);
		Constructor_Overloading d3 = new Constructor_Overloading("deepak");
	}

}
