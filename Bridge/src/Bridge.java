public abstract class Bridge {
    protected Road road;
    public void setRoad(Road road){
        this.road = road;
    }
    public abstract void go(String name);
}
