package Sample_Programs;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Remove_Duplicates_In_ArrayList 
{
	public static void main(String[] args)
	{
	ArrayList<String> g = new ArrayList<String>();
	g.add("Bala");		// index 0
	g.add("Sathish");	// index 1
	g.add("Bala");		// index 2
	g.add("Deepak");	// index 3
	g.add("Sathish");	// index 4
	g.add("Gokul");		// index 5

	// convert the ArrayList to LinkedHashSet to avoid duplicate entries

	g.toString();

	LinkedHashSet<String> h = new LinkedHashSet<String>(g);
	System.out.println(h);
	}	
}
