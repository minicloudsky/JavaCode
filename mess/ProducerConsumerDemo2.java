import java.util.concurrent.locks.*;
class ProducerConsumerDemo2
{
	public static void main(String[] args)
	{
		Resource res = new Resource();
		Producer pro = new Producer(res);
		Consumer con = new Consumer(res);
		Thread t1  = new Thread(pro);
		Thread t2 = new Thread(con);
		Thread t3 = new Thread(pro);
		Thread t4 = new Thread(con);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
class Resource  
{
	private String name;
	private int count =1;
	private boolean flag = false;// 
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public  void set(String name) throws InterruptedException
	{
		lock.lock();
		try
		{
		while(flag)
			condition.await();
		this.name = name + "---" +count++;
		System.out.println(Thread.currentThread().getName()+"...producer->"+this.name);
		flag = true;
		condition.signal();
	}
	finally
	{
		lock.unlock();
	}
	}
	public synchronized void out() throws InterruptedException
	{
		lock.lock();
		try{
		while(!flag)
			condition.await();
	 	System.out.println(Thread.currentThread().getName()+"Consumer"+this.name);
		flag = false;
		condition.signal();
		}
		finally{
			lock.unlock();
		}	
	}
}

class Producer implements Runnable
{
	private Resource res;
	Producer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				res.set("-set value-");
			}
			catch(InterruptedException e){}
		}
	}
}

class Consumer implements Runnable
{
	private Resource res;
	Consumer(Resource res)
	{
		this.res = res;
	}
	public void run()
	{
		while(true)
		{
			try
			{
				res.out();
			}
			catch(InterruptedException e){}
		}
	}
}
