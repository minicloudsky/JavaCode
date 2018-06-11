abstract class Moban
{
    public void goToLab() {
        System.out.print("去图书馆\t\t");
    }

    public abstract void doSth() ;

    public void outOfLab()
    {
        System.out.println("从图书馆出来\t");
    }
    public void process()
    {
        goToLab();
        doSth();
        outOfLab();
    }

}

class MoBanIm1 extends Moban
{


    public void doSth() {

        System.out.print("看书\t");

    }

}
class MoBanIm2 extends Moban
{


    public void doSth() {

        System.out.print("借书\t");

    }

}
class MoBanIm3 extends Moban
{


    public void doSth() {

        System.out.print("还书\t");
    }

}


public class PatternDesign {

    public static void main(String[] args) {
        System.out.println("15031210101      15软件工程1班               贾亚武");
        System.out.println("");
        Moban m1 = new MoBanIm1();
        Moban m2 = new MoBanIm2();
        Moban m3 = new MoBanIm3();
        System.out.println("模板方法是实现一：");
        m1.process();
        System.out.println("模板方法是实现二：");
        m2.process();
        System.out.println("模板方法是实现三：");
        m3.process();

    }
}