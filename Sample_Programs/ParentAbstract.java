package Sample_Programs;

abstract class ParentAbstract 
{
	abstract void Method1(); 	// ABSTRACT METHOD - MUST ONLY BE DECLARED IN ABSTRACT CLASS AND NOT TO BE DEFINED HERE

	void Method2()				// NON-ABSTRACT METHOD - MUST BE DEFINED HERE ITSELF
	{
	System.out.println(" Non-abstract Method2 from parent abstract ");
	}


}
