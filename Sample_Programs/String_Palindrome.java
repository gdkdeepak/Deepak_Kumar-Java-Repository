package Sample_Programs;

public class String_Palindrome 
{
	static boolean palindrome(String s)
	{
	String rev = "";
	for(int i=0;i<s.length();i++)
	{
	char ch = s.charAt(i);
	rev = rev + ch;
	}
	if(s==rev)
	{
	return true;
	}
	else
	return false;
	}

	public static void main(String[] args)
	{
	String s = "Good";

	s = s.toLowerCase();
	boolean res = palindrome(s);
	System.out.println("String Palindrome : "+res);
	}
}
