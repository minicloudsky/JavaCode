class ThreadTest
{
	public static void main(String[] args)
	{
		new Thread()
		{
			public void run()
			{
				for(int x=0;x<100;x++)
				{
					System.out.println(Thread.currentThread().getnme()+"...");
				}
			}
		}.start();
		for(int x=0;x<100;x++)
		{
			System.outt.println(Thread.currentThread.getName()+"...");
		}
		Runnable r = new Runnable()
		{
			public void run()
			{
				for( int x=0;x<100;x++)
				{
					System.out.println("...");
				}
			}
		};
		new Thread(r).start();
	}
}
class Test1 implements Runnable{
	public void run()
	{
		System.out.println("...");
	}
}