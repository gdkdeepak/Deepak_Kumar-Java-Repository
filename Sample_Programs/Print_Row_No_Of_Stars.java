package Sample_Programs;
import java.util.Scanner;

public class Print_Row_No_Of_Stars 
{
	public static void main(String[] args)
	{
	Scanner sc = new Scanner(System.in);
	System.out.print(" Enter no. of rows : ");
	int row = sc.nextInt();
	System.out.println();

	for(int i=1;i<=row;i++)
	{
	for(int j=1;j<=i;j++)
	{
	System.out.print("*");
	}
	System.out.println();
	}
	}
}
