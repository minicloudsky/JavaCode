public class NewCipherAdapter extends DataOperation
{
   private NewCipher cipher;
   
   public NewCipherAdapter()
   {
      cipher=new NewCipher();
   }
   
   public String doEncrypt(byte[] s)
   {
      return cipher.doEncrypt(s);
   }
}
