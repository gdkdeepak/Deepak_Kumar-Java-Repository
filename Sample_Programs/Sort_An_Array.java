package Sample_Programs;

public class Sort_An_Array 
{
	public static void main(String[] args)
	{
	int[] a = new int[] {34,56,87,98,07,54,02,13};

	for(int i=0;i<a.length;i++)
	{
	for(int j=i+1;j<a.length;j++)
	{
	int temp = 0;
	if(a[i]>a[j])
	{
	temp=a[i];
	a[i]=a[j];
	a[j]=temp;
	}
	}
	}
	System.out.println("Sorted Array : ");
	for(int i=0;i<a.length;i++)
	{
	System.out.println(a[i]);
	}
	}


}
