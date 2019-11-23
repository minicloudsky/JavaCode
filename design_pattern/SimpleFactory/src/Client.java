public class Client
{
    public static void main(String[] args){
        System.out.println("15级软件工程一班\n 杨子蘅学号:15031310135");
        try{
            Drink drink ;
            DrinkFactory factory;
            factory = (DrinkFactory) XMLUtil.getDrinkName();
            drink = factory.produceDrink();
            drink.getDrinkName();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
