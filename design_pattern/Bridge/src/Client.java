public class Client {
    public static void main(String args[]){
        Road road;
        Bridge bridge;
        System.out.println("���Ժ�  ������� 1 ��  15031210128 ");
        road = (Road)XMLUtilBridge.getBean("road");
        bridge = (Bridge)XMLUtilBridge.getBean("bridge");
        bridge.setRoad(road);
        bridge.go("����·");
    }
}
