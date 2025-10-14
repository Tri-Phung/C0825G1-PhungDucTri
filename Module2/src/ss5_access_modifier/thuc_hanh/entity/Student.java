package ss5_access_modifier.thuc_hanh.entity;

public class Student {
    private int rollNo;
    private String name;
    private static String college = "BBDIT";

    public Student(int r, String n) {
        rollNo = r;
        name = n;
    }

    public static void change() {
        college = "CODEGYM";
    }

    public void display() {
        System.out.println(rollNo + " " + name + " " + college);
    }
}
