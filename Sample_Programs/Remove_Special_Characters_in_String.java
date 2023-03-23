package Sample_Programs;

public class Remove_Special_Characters_in_String 
{
	public static void main(String[] args)
	{
	String s = "Special!£$Characters!£$%^&*()@";
	s = s.replaceAll("[^a-zA-Z0-9]","");
	System.out.println(s);
	}

}
