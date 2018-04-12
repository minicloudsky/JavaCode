import java.util.Base64;

public final class NewCipher
{
	public String doEncrypt(byte[] s)
	{
		String result = Base64.getEncoder().encodeToString(s);
		return result;
	}
}


