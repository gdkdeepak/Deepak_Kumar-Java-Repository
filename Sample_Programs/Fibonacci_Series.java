package Sample_Programs;
import java.util.Scanner;

public class Fibonacci_Series 
{
	static int n1=0;
	static int n2=1;
	static int n3=0;

	static void fibonacci(int count)
	{
	if(count>0)
	{
	n3=n1+n2;
	n1=n2;
	n2=n3;
	System.out.println(n3);
	fibonacci(count-1);

	}
	}

	public static void main(String[] args)
	{	// for printing first 10 fibonacci numbers
	Scanner sc = new Scanner(System.in);
	System.out.println(" Enter the count of fibonacci series : ");
	int count = sc.nextInt();
	System.out.println();

	System.out.println(n1);
	System.out.println(n2);
	fibonacci(count-2);

	}
}
