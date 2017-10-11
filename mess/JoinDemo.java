class Demo implements Runnable
{
	public void run()
	{
		for(int x=0;x<70;x++)
		{
			System.out.println(Thread.currentThread().toString()+"......"+x);
		Thread.yield();
		}
	}
}

class JoinDemo
{
	public static void main(String[] args)
	{
	Demo d = new Demo();
	Thread t1 = new Thread(d);
	Thread t2 = new Thread(d);
	t1.start();
	//t1.setPriority(Thread.MAX_PRIORITY);
	try{
	t1.join();
}
catch(Exception e){}
	t2.start();
	for(int x=0;x<80;x++)
	{
		System.out.println("main....."+x);
	}
	System.out.println("Over");
}
}