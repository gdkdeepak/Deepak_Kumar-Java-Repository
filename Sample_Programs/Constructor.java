package Sample_Programs;

public class Constructor 
{
	Constructor()
	{
	System.out.println("No Argument constructor");
	}

	Constructor(int a)
	{
	System.out.println("Parameterized constructor with Int parameter "+a);
	}

	Constructor(String s)
	{
	System.out.println("Parameterized constructor with String parameter "+s);
	}

	public static void main(String[] args) {
	Constructor d1 = new Constructor();
	Constructor d2 = new Constructor(53);
	Constructor d3 = new Constructor("deepak");

	}
}
