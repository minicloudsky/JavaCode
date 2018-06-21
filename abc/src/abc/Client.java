package abc;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("15031210128 уерт╨Ц");
		Component o1,o2;
		Activity a1,a2,a3;
		
		o1=new Leaf1();
		o2=new Leaf2();
		
		a1=new Activity();
		a1.add(o1);
		a1.add(o2);
		
		a2=new Activity();
		a2.add(o1);
		a2.add(o1);
		
		a3=new Activity();
		a3.add(o2);
		a3.add(a2);
		a3.add(a1);
		
		a3.manage();
	}

}
