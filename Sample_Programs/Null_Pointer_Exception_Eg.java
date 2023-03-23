package Sample_Programs;

public class Null_Pointer_Exception_Eg 
{
	void Null_Pointer_Exception()
	{
	String s=null;
	int i = s.length();
	System.out.println(i); // length of a null string
	}
	public static void main(String[] args)
	{
	Null_Pointer_Exception_Eg d = new Null_Pointer_Exception_Eg();
	d.Null_Pointer_Exception();
	}
}
