class Resource  
{
	private String name;
	private int count =1;
	private boolean flag = false;// 
	public synchronized void set(String name)
	{
		while(flag){
			try{this.wait();}catch(Exception e){}
		}
		this.name = name + "---" +count++;
		System.out.println(Thread.currentThread().getName()+"...producer->"+this.name);
		flag = true;
		this.notifyAll();
	}
	public synchronized void out()
	{
		while(!flag){
			try{this.wait();} catch(Exception e){}
		}
		System.out.println(Thread.currentThread().getName()+"Consumer"+this.name);
		flag = false;
		this.notifyAll();		
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
			res.set("-set value-");
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

class ProducerConsumerDemo
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