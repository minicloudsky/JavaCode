public class MilkFactory implements DrinkFactory
{
    @Override
    public Drink produceDrink() {
        System.out.println("牛奶工厂生产牛奶");
        return new Milk();
    }
}
