public class CipherAdapter extends DataOperation
{
	private MyBase64 cipher;
	
	public CipherAdapter()
	{
		cipher=new MyBase64();
	}
	
	public String doEncrypt(byte[] s)
	{
		return cipher.doEncrypt(s);
	}
}