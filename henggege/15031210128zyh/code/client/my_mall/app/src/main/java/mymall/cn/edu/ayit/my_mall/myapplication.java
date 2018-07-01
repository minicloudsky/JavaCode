package mymall.cn.edu.ayit.my_mall;


import android.app.Application;

/**
 * Created by Administrator on 2017/12/31 0031.
 */

public class myapplication extends Application {
    private static String sessionid;
    public static String ip="http://172.22.95.249:8080/mymall/";

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getSessionid()
    {
        return this.sessionid;
    }

}
