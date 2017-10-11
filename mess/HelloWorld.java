import java.util.Random;
public class HelloWorld
{
	public static void main(String[] args)
	{
		System.out.println(randomString(-229985452)+' '+randomString(-147909649));
	}
	public static String randomString(int seed)
	{
		Random rand = new Random(seed);
		StringBulider sb = new StringBulider();
		while(true)
		{
			in n = rand.nextInt(27);
			if(n==0)
				break;
			sb.append((char)'`' + n);
		}
		return sb.toString();

	}
}