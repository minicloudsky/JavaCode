import java.util.ArrayList;
import java.util.Iterator;


public class Client {
   public static void main(String[] args){
       //1.单例模式
       DinningHall dh = DinningHall.getInstance();
       //2.工厂模式
       Food f1 = DinningHall.createFood("1号菜");
       System.out.println(f1.getName());
       //3.建造者模式
       DinningHall.produceSomeMantou(5);
       /**
        * 测试方法应该写在main函数里面，
        * 非静态方法只能创建对象后调用，只有静态方法和变量才可以直接用类名调用
        */
       System.out.println("张婷婷");
       ArrayList<Food> foods =dh.getFoods();
//       遍历输出list中元素时候，建议使用迭代器
       Iterator<Food> it = foods.iterator();
       while (it.hasNext()){
           System.out.println(it.next().getName());
       }
//       for(Food f : foods){
//           System.out.println(foods +"\t");
//       }
   }
}







