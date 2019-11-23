package com.company;
public class Client
{
    public static void main(String a[])
    {
        TaskManagerSingleton ps1,ps2;
        System.out.println("15031210101 软件工程一班 贾亚武");
        try
        {
            ps1=TaskManagerSingleton.getInstance();
            ps1.manageJobs();
        }
        catch(TaskManagerException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------------");
        try
        {
            ps2=TaskManagerSingleton.getInstance();
            ps2.manageJobs();
        }
        catch(TaskManagerException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

