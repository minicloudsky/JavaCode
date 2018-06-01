
public class Client {
    public static void main(String[] args) {
        System.out.println("15031210116 Õı’’ø∆");
        Car car = new Car();
        car.move();
        System.out.println("Add new function : flying");
        FlyCar flycar = new FlyCar(car);
        flycar.move();
        System.out.println("Add new function: swimming");
        WaterCar waterCar = new WaterCar(car);
        waterCar.move();
        System.out.println("Add new function: flying,swimming");
        WaterCar waterCar2 = new WaterCar(new FlyCar(car));
        waterCar2.move();
    }
}