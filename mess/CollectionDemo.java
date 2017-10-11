import java.util.*;
class CollectionDemo
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add("454");
		al.add("sb");
		al.add("three");
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}