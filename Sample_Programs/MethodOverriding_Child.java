package Sample_Programs;

public class MethodOverriding_Child extends MethodOverriding_Parent
{
	// method overriding child class
	public static void main(String[] args)
	{
	MethodOverriding_Child o = new MethodOverriding_Child();
	o.run();  // child class accessing parent class method
	}
}