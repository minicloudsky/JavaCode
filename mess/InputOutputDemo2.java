class Res{
	private String name;
	private String sex;
	private int flag = 0;// 0-> false 1 -> true
	public synchronized   void set(String name,String sex)// Input the value
	{
		if(flag == 1)
			try{this.wait();} catch(Exception e){}
		this.name = name;
		this.sex = sex;
		flag =1;
		this.notify();
	}
	public synchronized void out()// print value
	{
		if(flag ==0)
			try{this.wait();} catch(Exception e){}
		System.out.println(name+"-------"+sex);
		flag = 0;
		this.notify();
	}
}
class Input implements Runnable
{
	private Res r;
	Input (Res r)
	{
		this.r = r; 
	}
	public void run()
	{
		int flag = 1;
		  while(true)
		{
			if(flag%2==0)
			{
				r.set("AAAAAAA","aaaaaaaa");
			}
			else
			{
				r.set("BBBBBBB","bbbbbbbb");
			}
			flag = flag+1;
		}
	}
}
class Output implements Runnable{
	private Res r;
	Output(Res r){
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
	} }
}
class InputOutputDemo2
{
	public static void main(String[] args)
	{
		Res r = new Res();
		new Thread(new Input(r)).start();
		new Thread(new Output(r)).start();
	}
}