import java.util.concurrent.locks.*;
class Resource  
{
	private String name;
	private int count =1;
	private boolean flag = false;// 
	private Lock lock = new ReentrantLock(); 
	private Condition con_producer = lock.newCondition();
	private Condition con_consumer = lock.newCondition();
	public void set(String name) throws InterruptedException
	{
		lock.lock();
		try  
		{
		while(flag)
		{
			con_producer.await();		
		}
		this.name = name + "---" +count++;
		System.out.println(Thread.currentThread().getName()+"...jiayabo eat "+this.name+"apple");
		flag = true;
		con_consumer.signal();
	}
	finally
	{
		lock.unlock();
	}
	}
	public  void out()
	{
		lock.lock();
	try
	{
		while(!flag)
		{
			try{con_consumer.await();}	catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName()+"...jiayabo eat "+this.name+"apple");
		flag = false;
		con_producer.signal();
	}
	finally
	{
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
			try {
				res.set("-set value-");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			res.out();
		}
	}
}

 class DuoXianCheng
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
