class MyLock
{
	public static Object locka = new Object();
	public static Object lockb = new Object();
}
class Lock implements Runnable
{
	public boolean flag;
	public Lock(boolean flag)
	{
		this.flag = flag;
	}
	public void run()
	{
		if(flag)
		{
			synchronized(MyLock.locka)
			{
				System.out.println("if locka");
				synchronized(MyLock.lockb)
				{
					System.out.println("if lockb");
				}
			}
		}
		else
		{
			synchronized(MyLock.locka)
			{
				System.out.println("else locka");
				synchronized(MyLock.lockb)
				{
					System.out.println("else lockb");
				}
			}
		}

	}
}
class DeadLockDemo
{ 
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new Lock(true));
		Thread t2 = new Thread(new Lock(false));
		t1.start();
		t2.start();
	}
}