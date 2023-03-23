package Sample_Programs;
import java.util.LinkedList;

public class Exception_Handling_Using_Try_Catch 
{
	void ArithMetic_Exception()
	{
	int a=10;
	int b=0;

	try
	{
	int c=a/b;		// no value can be divided by zero
	System.out.println(c);
	}
	catch(ArithmeticException e)
	{
	System.out.println(e);
	}
	}
	void Null_Pointer_Exception()
	{
	String s=null;
	try
	{
	int i = s.length();
	System.out.println(i); // length of a null string
	}
	catch(NullPointerException e)
	{
	System.out.println(e);

	}
	}
	void Number_Format_Exception()
	{
	String s="123A";
	try
	{
	int i = Integer.parseInt(s);	// string 's' contains alphanumeric character
	System.out.println(i);
	}
	catch(NumberFormatException e)
	{
	System.out.println(e);
	}
	}
	void String_Index_Out_of_Bounds_Exception()
	{
	String s = "Java";
	try
	{
	String s1 = s.substring(0,15); // String index out of bounds
	System.out.println(s1);
	}
	catch(StringIndexOutOfBoundsException e)
	{
	System.out.println(e);
	}
	}
	void Array_Index_Out_of_Bounds_Exception()
	{
	String [] s = new String[] {"Deepak","Sathis","Bala","Gokul"};
	try
	{
	System.out.println(s[4]);	// array index out of bounds
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
	System.out.println(e);
	}
	}
	void Index_Out_of_Bounds_Exception()
	{
	LinkedList<String> q = new LinkedList<String>();
	q.add(null);
	q.add("Felix");
	q.add("Derick");
	try
	{
	System.out.println(q.get(3));	// Index out of bounds for Collection 'q'
	}
	catch(IndexOutOfBoundsException e)
	{
	System.out.println(e);
	}
	}
	public static void main(String[] args)
	{
	Exception_Handling_Using_Try_Catch P = new Exception_Handling_Using_Try_Catch();
	P.ArithMetic_Exception();
	P.Null_Pointer_Exception();
	P.Number_Format_Exception();
	P.String_Index_Out_of_Bounds_Exception();
	P.Array_Index_Out_of_Bounds_Exception();
	P.Index_Out_of_Bounds_Exception();
	}	
}
