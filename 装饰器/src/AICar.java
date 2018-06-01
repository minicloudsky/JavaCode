class AICar extends SuperCar{
    public AICar(ICar car) {
        super(car);
    }
    public void autoMove(){
        System.out.println("running automously");
    }
    @Override
    public void move() {
        super.move();
        autoMove();
    }
}