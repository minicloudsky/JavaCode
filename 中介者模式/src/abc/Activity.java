package abc;

import java.util.ArrayList;

public class Activity implements Component {

	
	private ArrayList list =new ArrayList();
	@Override
	public void manage() {
		// TODO Auto-generated method stub
		
		for(Object object :list)
		{
			((Component)object).manage();
			
		}
		
	}
	
	
	public void add(Component c)
	{
		list.add(c);
	}

	public void remove(Component c)
	{
		list.remove(c);
	}
	
}
