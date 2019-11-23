import java.util.Base64;
import java.util.Base64.*;
public class MyBase64 {
    public String doEncrypt(byte[] s)
    {
        for(int i=0;i<s.length;i++)
        {
            s[i] = (byte) i;
        }
        String result = Base64.getEncoder().encodeToString(s);
        return result;
    }
}