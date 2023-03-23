package Sample_Programs;

public class Reverse_A_String 
{
	public static void main(String[] args) {
	String s = "Computer Science";
	char ch;
	String str = "";
	for(int i=0;i<s.length();i++)
	{
	ch = s.charAt(i);
	str = ch+str;
	}
	System.out.println("Reversed String : "+str);
	}
}
