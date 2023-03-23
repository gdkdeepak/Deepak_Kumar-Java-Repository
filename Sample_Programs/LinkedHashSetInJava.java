package Sample_Programs;
import java.util.LinkedHashSet;

public class LinkedHashSetInJava  //	SET   => ignores duplicate data
{					// LINKED => SIGNIFIES INSERTION ORDER

public static void main(String[] args)
{
LinkedHashSetInJava a = new LinkedHashSetInJava();
a.Basic_Fun();
}
void Basic_Fun()
{
LinkedHashSet<String> g = new LinkedHashSet<String>();

// To add data into LinkedHashSet
g.add("Bala");		// index 0
g.add("Sathis");	// index 1
g.add("Sentamil");	// index 2
g.add("Deepak");
g.add("Krishnan");
g.add("Kumar");
g.add("Selvan");
g.add("Dilip");		// index 7
g.add("Deepak");    // ignores duplicate data doesnot throw error	// index 8

// To find the size of LinkedHashSet
System.out.println("Length of LinkedHashSet ==> "+g.size());
System.out.println();

// To print all data in LinkedHashSet
//  Type 1
System.out.println("*********** PRINT ALL DATA USING FOR EACH *******");
for (String c : g)
{
System.out.println(c);
}
System.out.println();
}
}
