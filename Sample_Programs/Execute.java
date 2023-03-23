package Sample_Programs;

public class Execute
{
public static void main(String[] args)
{
ParentAbstract p = new Child1Abstract();// this type of object can access only the methods in ParentAbstract  class
p.Method1();
p.Method2();
System.out.println();


ParentAbstract c = new Child2Abstract();// this type of object can access only the methods in ParentAbstract  class
c.Method1();
c.Method2(); 				// overrides Method2 of ParentAbstract class
System.out.println();


Child2Abstract f = new Child2Abstract();	// this type of object can access both ParentAbstract class & Child2Abstract  methods
f.Method3();
f.Method1();
f.Method2();					// overrides Method2 of ParentAbstract class
System.out.println();


Child1Abstract g = new Child1Abstract();	// this type of object can access both ParentAbstract class & Child1Abstract  methods
g.Method();
g.Method1();
g.Method2();				/* Note the variation in O/P of Method2() */
System.out.println();
}
}
