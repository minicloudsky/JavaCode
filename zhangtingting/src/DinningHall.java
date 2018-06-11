import java.util.ArrayList;

public  class DinningHall{
    private static DinningHall instance = null;
    //建造者模式start：集中管理，生产一些吃的东西
    public static ArrayList<Food> list = new ArrayList<Food>();
    public static DinningHall getInstance(){
        //单例模式：创建食堂对象
        if(instance == null){
            instance = new DinningHall();
        }
        return instance;
    }

    public static Food createFood(String order){
        //工厂模式：创建一些吃的
        if("1号菜".equals(order)){
            //比如菜单上1号菜是鱼香肉丝
            return new YuXiangRouSi();
        }
        else if("2号菜".equals(order)){
            //比如菜单上2号菜是宫保鸡丁
            return new GongBaoJiDing();
        }
        else{
            return null;
        }
    }

    public static void produceSomeMantou(int count){
        for(int i=0; i<count; i++){
            list.add(new ManTou());
        }
    }

    public ArrayList<Food> getFoods(){
        return list;
    }

}