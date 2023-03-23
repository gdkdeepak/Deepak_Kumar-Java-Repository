package Sample_Programs;
import java.util.Scanner;

public class Armstrong_Number 
{
	static boolean armstrong(int n)
	{
	int temp, dig=0, last=0, sum=0;
	temp=n;

	while(temp>0)
	{
	temp=temp/10;
	dig++;
	}
	temp=n;
	while(temp>0)
	{
	last=temp%10;
	sum+=(Math.pow(last,dig));
	temp=temp/10;
	}
	if(n==sum)
	return true;
	else
	return false;
	}

	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);
	System.out.println(" Enter the digit for which you want to check Armstrong condition : ");
	int f = sc.nextInt();
	System.out.println();

	if(armstrong(f))
	{
	System.out.println(f+" is an ARMSTRONG NUMBER");
	}
	else
	{
	System.out.println(f+" is not an ARMSTRONG NUMBER");
	}
	}


}
