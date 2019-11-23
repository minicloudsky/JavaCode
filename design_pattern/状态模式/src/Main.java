abstract class HungryState {
    protected int hungryNum = 0; // 饥饿值
    protected String stateName;
    protected Cat cat;

    public abstract void checkHungry(int num);

    // 吃东西
    public void eat(int food) {
        System.out.println("你喂宠物狗" + cat.getCatName() + "吃了" + food + "克事物。");
        this.hungryNum += food;
        int num = hungryNum;
        this.checkHungry(num);
        System.out.println("当前宠物狗的饥饿值是" + this.hungryNum + ",当前状态为：" + this.cat.getState().stateName);
    }
}

// 具体状态类1
class HungryMuch extends HungryState {
    public HungryMuch(HungryState ste) {
        this.cat = ste.cat;
        this.hungryNum = ste.hungryNum;
        this.stateName = "极度饥饿";
    }

    public HungryMuch(Cat cat) {
        this.cat = cat;
        this.hungryNum = 0;
        this.stateName = "极度饥饿";
    }

    public void checkHungry(int num) {

        if (num >= 3) {
            cat.setState(new HungryEatUp(this));
        } else if (num >= 2) {
            cat.setState(new HungryNot(this));
        } else {
            System.out.println("宠物狗" + this.cat.catName + "还很饿！");
        }
    }
}

// 具体状态类2
class HungryNot extends HungryState {
    public HungryNot(HungryState ste) {
        this.cat = ste.cat;
        this.hungryNum = ste.hungryNum;
        this.stateName = "温饱状态";
    }

    public void checkHungry(int num) {

        if (num >= 3) {
            cat.setState(new HungryEatUp(this));
        }
    }
}

// 具体状态类3
class HungryEatUp extends HungryState {
    public HungryEatUp(HungryState ste) {
        this.cat = ste.cat;
        this.hungryNum = ste.hungryNum;
        this.stateName = "宠物狗吃撑了";
    }

    public void checkHungry(int num) {
        System.out.println("宠物狗已经吃不下了1~~");

    }
}

// 环境类
class Cat extends HungryState {
    protected String catName = null;
    protected HungryState state;

    public Cat(String name) {
        state = new HungryMuch(this);
        this.cat = this;
        this.catName = name;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public HungryState getState() {
        return state;
    }

    public void setState(HungryState state) {
        this.state = state;
    }

    public void eat(int food) {

        this.state.eat(food);
    }

    public void checkHungry(int num) {

        this.state.checkHungry(num);
    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println("15031210128      15软件工程1班      贾亚武");
        System.out.println();
        Cat s = new Cat("旺财");
        for (int i = 1; i <= 3; i++) {
            System.out.println(i + ":");
            s.eat(1);
        }
    }
}