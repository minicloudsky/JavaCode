public class Test{
    public static void main(String[] args) {
    try{
      int result = divide(4,-8);
        System.out.println(result);
    }
    catch (DivideByMinusException e){
        System.out.println(e.getMessage());
    }

    }
    //两个数相除的函数，如果除数小于0，抛出异常
    public static int divide(int x,int y) throws DivideByMinusException
    {
        if(y<0)
            throw new DivideByMinusException("被除数是负数");
        int result = x/y;
        return result;
    }
}
class DivideByMinusException extends Exception
{
    public DivideByMinusException(){
        super();//无参数调用的构造方法
    }
    public DivideByMinusException(String message){
        super(message); //调用Exception有参数的构造方法
    }
}

