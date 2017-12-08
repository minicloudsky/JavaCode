package cn.itcast;
//导入java迭代器
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Iterator;
import java.util.Scanner;

//定义该类在cn.itcast包下面
public class Test
{
    //经理继承自基本员工，经理在基本工资的基础上还有奖金，计算出经理的薪水
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("输入姓名:");
        String name = input.next();
        System.out.println("输入年龄");
        int age = input.nextInt();
        System.out.println("输入基本工资");
        int basic = input.nextInt();
        System.out.println("输入奖金");
        int bounce = input.nextInt();
        Manage m = new Manage();
        m.age = age;
        m.name = name;
        m.basic = basic;
        m.bounce = bounce;
        System.out.println(m.name+" Total salary:"+(m.bounce+m.basic)+"age: "+m.age);
    }
}
class Basic
{
    public String name;
    public int age;
    public int basic;
}
class Manage extends Basic{
    public int bounce;

}