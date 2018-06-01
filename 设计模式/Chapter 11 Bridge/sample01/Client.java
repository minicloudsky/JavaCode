public class Client
{
	public static void main(String a[])
	{
		Bridge bridge;
		Road road;
		
		road=(Road)XMLUtilBridge.getBean("road");
		bridge=(Bridge)XMLUtilBridge.getBean("bridge");
		
		bridge.setPlace(road);
		bridge.("Â×¶Ø");
	}
}