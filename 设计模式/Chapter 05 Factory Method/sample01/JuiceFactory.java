public class JuiceFactory implements DrinkFactory
{
    public TV produceTV()
    {
    	System.out.println("һ����֭");
    	return new JuiceFactory();
    }
}