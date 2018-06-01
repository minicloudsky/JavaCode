public class FlyCar extends SuperCar {
    public FlyCar(ICar car){
        super(car);
    }
    public void fly(){
        System.out.println("fly in the sky");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}
