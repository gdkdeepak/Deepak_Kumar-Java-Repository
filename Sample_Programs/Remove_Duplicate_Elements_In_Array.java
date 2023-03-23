package Sample_Programs;
import java.util.LinkedHashSet;

public class Remove_Duplicate_Elements_In_Array 
{
	public static void main(String[] args)
	{
	// array with duplicate entries
	int a[]= {5,3,4,5,6,7,3,9,4,3,5};

	// LinkedHashSet removes duplicate entries
	LinkedHashSet<Integer> h = new LinkedHashSet<Integer>();

	for(int i=0;i<a.length;i++)
	{
	h.add(a[i]);
	}
	System.out.println(h);
	}
}
