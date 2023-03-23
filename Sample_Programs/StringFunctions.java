package Sample_Programs;

public class StringFunctions 
{
	public static void main(String[] args)
	{
	String s = "deepak kumar";
	// length of string
	System.out.println(" Length of string : "+s.length());

	String s1 = "Gokul";
	String s2 = "Sentami";
	String s3 = "Selvan";
	// concatenate strings and store it in a new string
	String s4 = s1+s2+s3;
	System.out.println(s4);

	String st = " Sathis Kumar is sleeping ";
	String sr = s1.replace("Sathis", "bala");			// string to string replacement
	System.out.println(" string s1 after replace : "+sr);
	System.out.println();

	}


}
