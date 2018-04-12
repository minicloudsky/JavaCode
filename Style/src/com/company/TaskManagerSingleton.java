package com.company;
public class TaskManagerSingleton {
    private static TaskManagerSingleton instance=null;
    private TaskManagerSingleton() {
    }
    public static TaskManagerSingleton getInstance() throws TaskManagerException {
        if(instance==null) {
            System.out.println("打开Windows任务管理器！");
            instance=new TaskManagerSingleton();
        }
        else {
            throw new TaskManagerException("任务管理器正在工作中！"); }
        return instance;
    }

    public void manageJobs() {
        System.out.println("管理windows进程！");
    }
}