package ss4_class_and_object.bai_tap.fan;

public class Main {
    static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.SLOW);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        System.out.println("fan 1:");
        System.out.println(fan1.toString());
        System.out.println("fan 2:");
        System.out.println(fan2.toString());
    }
}
