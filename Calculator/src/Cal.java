import java.io.IOException;

public class Cal {
public  static  void  main(String[] args)
{
    Runtime runtime = Runtime.getRuntime();
    try{
        runtime.exec("calc");
    } catch (IOException e){
        e.printStackTrace();
    }
}
}
