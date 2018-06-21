package com;

public class Notepad extends Changer {
    public Notepad(Machine machine){
        super(machine);
        System.out.println("机器变成记事本");
    }
    public void work(){
        try {
            Process pro = Runtime.getRuntime().exec("notepad.exe");
            pro.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(")~^~(我是装饰模式产生的Windows系统记事本。~~~");
    }
    public void say(){
        System.out.println("机器变成记事本");
    }
}
