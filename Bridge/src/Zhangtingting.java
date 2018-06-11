import java.awt.List;
import java.util.ArrayList;
public class Client {
    //1.单例模式
    DinningHall dh = DinningHall.getInstance();
    //2.工厂模式
    Food f1 = DinningHall.createFood("1号菜");
    System.out.println(f1.getName());
    //3.建造者模式
    DinningHall.produceSomeMantou(5);
    ArrayList<Food> foods =DinningHall.getFoods();
    for(Food f : foods){
        String foods;
        System.out.println(foods +"\t");
    }
}
class DinningHall{
    private static DinningHall instance = null;
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
    //建造者模式start：集中管理，生产一些吃的东西
    private ArrayList<Food> list = new ArrayList<Food>();
    public ArrayList<Food> getFoods(){
        return list;

    }
    public void produceSomeMantou(int count){
        for(int i=0; i<count; i++){
            list.add(new ManTou());
        }
    }}
//建造者模式end
//##食物：Food.java
interface Food{
    public String getName();
}
//##鱼香肉丝：YuXiangRouSi.java
class YuXiangRouSi implements Food{
    public String getName(){
        return "鱼香肉丝";
    }
}
//##宫保鸡丁：GongBaoJiDing.java
class GongBaoJiDing implements Food{
    public String getName(){
        return "宫保鸡丁";
    }
}
//##馒头：Mantou.java
class ManTou implements Food{
    public String getName(){
        return "馒头";
    }
}

