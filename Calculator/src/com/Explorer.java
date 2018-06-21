package com;
public class Explorer extends Changer {
    public Explorer(Machine machine){
        super(machine);
        System.out.println("机器变成Windows资源管理器。");
    }
    public  void work() {
        try {
            Process pro = Runtime.getRuntime().exec("explorer.exe");
            pro.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("~~~我是装饰模式产生的Windows资源管理器~~~");
    }
}
