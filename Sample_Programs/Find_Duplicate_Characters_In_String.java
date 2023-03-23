package Sample_Programs;

public class Find_Duplicate_Characters_In_String 
{
	public static void main(String[] args)
	{
	String str = "Deepak Kumar";
	int count ;

	char s[]=str.toCharArray();

	for(int i=0;i<str.length();i++)
	{
	count =0;
	for(int j=i+1;j<str.length();j++)
	{
	if((s[i]==s[j]))
	{
	count++;
	s[j]='0';
	}
	}
	if((count>0)&&(s[i]!='0'))
	{
	System.out.println(s[i]);
	}
	}
	}
}
