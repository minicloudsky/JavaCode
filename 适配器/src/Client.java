public class Client
{
   public static void main(String args[])
   {
        System.out.println("���Ժ�  ������� 1 ��  15031210128");
        DataOperation dao=(DataOperation)XMLUtil.getBean();
      byte[] s = new byte[40];
      for(int i=0;i<s.length;i++){
          s[i] = (byte) i;
        }
      String es=dao.doEncrypt(s);
      System.out.print("Base64 ����ǰ������Ϊ��");
      for(int i=0;i<s.length;i++)
            System.out.print(s[i]);
        System.out.println();
        System.out.println("Base64����������Ϊ��" + es);
   }
}
