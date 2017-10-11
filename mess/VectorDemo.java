import java.util.*;
class VectorDemo
{
	public static void main(String[] args)
	{
		Vector v = Vector();
		v.add("32");
		v.add("javadssdss");
		v.add("sbbbbc");
		Enumeration en = v.elements();
		while(en.hasMoreElements())
		{
			System.out.println(en.nextElement());
		}
	}
}