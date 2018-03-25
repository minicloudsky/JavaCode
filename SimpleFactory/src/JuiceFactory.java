public class JuiceFactory implements DrinkFactory {
    @Override
    public Drink produceDrink() {
        System.out.println("果汁工厂生产果汁");
        return new Juice();
    }
}
