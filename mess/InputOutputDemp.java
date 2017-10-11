class Res{
	String name;
	String sex;
	int flag = 0;// 0-> false 1 -> true
}
class Input implements Runnable{
	private Res r;
	Object obj = new Object();
	Input (Res r){
		this.r = r; }
	public void run()
	{
		int flag=0;
		  while(true)
		{
			synchronized(r)
			{
				if(r.flag == 1)
				{
					try{r.wait();}catch(Exception e){}
				}
			if(flag==0)
			{
				r.name = "AAAAAAA";
				r.sex = "aaaaaaaa";
			}
			else
			{
				r.name = "BBBBBBB";
				r.sex = "bbbbbbbb";
			}
			r.flag = 1;
			r.notify();
		}
			flag = (flag+1)%2;
		}
	}
}
class Output implements Runnable{
	private Res r;
	Output(Res r){
		this.r = r;
	}
	public void run(){
		while(true)
		{
			synchronized(r){
				if(r.flag == 0)
				{
					try{r.wait();} catch(Exception e){}
				}
			System.out.println(r.name+"----"+r.sex);
			r.flag = 0;
			r.notify();
	} }
}
}
class InputOutputDemp
{
	public static void main(String[] args)
	{
		Res r = new Res();
		Input in = new  Input(r);
		Output out = new Output(r);
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		t1.start();
		t2.start();
	}
}