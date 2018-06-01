public class JuiceFactory implements DrinkFactory
{
    public TV produceTV()
    {
    	System.out.println("Ò»±­¹ûÖ­");
    	return new JuiceFactory();
    }
}