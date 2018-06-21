package com;
import java.io.ObjectInputStream;
public final class SystemCalculator implements Machine,Cloneable
{
    public SystemCalculator(){
        System.out.println("这台机器是一个计算器.");
    }
    public  void work() {
        try {
            Process pro = Runtime.getRuntime().exec("calc.exe");
            pro.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("我是装饰模式产生的Windows系统计算器");
    }
    /**
     * 原型模式实现浅拷贝
     * @return
     */
    public Object clone()
    {
        SystemCalculator clone = null;
        try{
            clone = (SystemCalculator)super.clone();
        }
        catch (CloneNotSupportedException e){
            System.out.println("Clone failure");
        }
        return clone;
    }
}
