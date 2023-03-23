package Sample_Programs;

public class UsingInterface implements Parent1Interface,Parent2Interface 
{
	public void Method1()
	{
	System.out.println(" Parent 1 Interface Method 1 ");
	}

	public void Method2()
	{
	System.out.println(" Parent 1 Interface Method 2 ");

	}

	public void Method3()
	{
	System.out.println(" Parent 2 Interface Method 3 ");

	}

	public void Eg()
	{
	System.out.println(" Using Interface Eg Method");
	}

	public static void main(String[] args)
	{
	UsingInterface u = new UsingInterface();
	u.Method1();
	u.Method2();
	u.Method3();
	u.Eg();
	System.out.println();

	Parent1Interface p1 = new UsingInterface();
	p1.Method1();
	p1.Method2();
	System.out.println();


	Parent2Interface p2 = new UsingInterface();
	p2.Method3();
	System.out.println();
	}

}

