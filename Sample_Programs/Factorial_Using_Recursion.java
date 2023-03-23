package Sample_Programs;
import java.util.Scanner;

public class Factorial_Using_Recursion
{
	static long factorial(int n)
	{
	int value;
	if(n>=1)
	{
	return n*factorial((n-1));
	}
	else
	{
	return 1;
	}
	}

	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);
	System.out.println(" Enter the digit for which you want to find factorial : ");
	int f = sc.nextInt();
	System.out.println();

	long value = factorial(f);
	System.out.println("Factorial value : "+value);
	}
}
