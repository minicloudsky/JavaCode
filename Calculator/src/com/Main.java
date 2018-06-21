package com;

public class Main {
    public static void main(String[] args){
        //原型模式实现系统中只有一个Claculator的实例，节省系统内存
        System.out.println("15031210101 软件工程一班 贾亚武");
        Calculator calculator = Calculator.getCalculatorInstance();
//        Machine machine;
//        machine = new SystemCalculator();
//        machine.work();
//        System.out.println("~~~~~~~~~~~~~~~~~~~~");
////        //装饰模式扩展计算器的功能，使得计算器有记事本和调用系统计算器，以及资源管理器的功能.
//        Notepad systemNotepad = new Notepad(machine);
//        SystemCalculator systemCalculator = new SystemCalculator();
//        Explorer explorer = new Explorer(machine);
//        explorer.work();
//        systemNotepad.work();
//        systemNotepad.say();
//        systemCalculator.work();
//        machine.work();
//        浅拷贝深拷贝
        SystemCalculator cla1 ,copycalculator;
       cla1 = new SystemCalculator();
        copycalculator = (SystemCalculator) cla1.clone();
        System.out.println("通过原型模式实现的浅拷贝的两个对象相同吗?");
        System.out.println(copycalculator==cla1);
    }
}
