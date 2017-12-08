package cn.itcast;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class MyThread
{
    public static void main(String[] args)
    {
        //创建Ticket对象
        Ticket ticket = new Ticket();
        //开启四个线程
        new Thread(ticket,"线程1").start();
        new Thread(ticket,"线程2").start();
        new Thread(ticket,"线程3").start();
        new Thread(ticket,"线程4").start();
    }
}

class Ticket implements Runnable{
    private int ticket = 200;
    Object lock = new Object();
    public void run()
    {
        while (true)
        {
            synchronized (lock){
                try{
                    Thread.sleep(10);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖出的票: "+ticket--);
                }
                else
                {
                    break;
                }
            }
        }
    }
}
