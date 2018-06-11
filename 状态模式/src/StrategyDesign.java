abstract class Zuidagongyue {
    String aluName;

    public String getAluName() {
        return aluName;
    }

    public void setAluName(String aluName) {
        this.aluName = aluName;
    }

    public abstract int algorithm(int a, int b);
}

class Zuidagongyue1 extends Zuidagongyue {


    public int algorithm(int a, int b) {
        if (a == 0 || b == 0)

        {
            System.out.println("错误输入！！");
            return 0;

        }
        if (a < 0 || b < 0) {
            System.out.println("自动转化为正数");
            a = Math.abs(a);
            b = Math.abs(b);
        }
        // 相减法
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
}

class Zuidagongyue2 extends Zuidagongyue {


    public int algorithm(int a, int b) {
        if (a == 0 || b == 0)

        {
            System.out.println("错误输入！！");
            return 0;

        }
        if (a < 0 || b < 0) {
            System.out.println("自动转化为正数");
            a = Math.abs(a);
            b = Math.abs(b);
        }
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        int t;
        while (b != 0) {
            t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}

class FindDz {
    private Zuidagongyue u;

    public Zuidagongyue getU() {
        return u;
    }

    public void setU(Zuidagongyue u) {
        this.u = u;
    }

    public int getDz(int a, int b) {
        return this.u.algorithm(a, b);
    }
}

public class StrategyDesign {

    public static void main(String[] args) {
        System.out.println("15031210101      15软件工程1班               贾亚武");
        System.out.println("");
        FindDz f = new FindDz();
        Zuidagongyue z1 = new Zuidagongyue1();
        z1.setAluName("更削减损法");
        Zuidagongyue z2 = new Zuidagongyue2();
        z2.setAluName("辗转相除法");
        f.setU(z1);
        System.out.println(z1.getAluName() + ":" + f.getDz(4, 12));
        f.setU(z2);
        System.out.println(z2.getAluName() + ":" + f.getDz(4, 12));
    }
}