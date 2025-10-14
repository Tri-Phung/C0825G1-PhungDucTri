package ss5_access_modifier.thuc_hanh.controller;

import ss5_access_modifier.thuc_hanh.entity.Car;
import ss5_access_modifier.thuc_hanh.entity.Student;

public class Main {
    public static void main(String[] args) {
        // Pratice Static method
        Student.change();
        Student s1 = new Student(111, "Hoang");
        Student s2 = new Student(222, "Khanh");
        Student s3 = new Student(333, "Nam");

        s1.display();
        s2.display();
        s3.display();

        // Practice Static property
        Car car1 = new Car("Mazda 3","Skyactiv 3");
        System.out.println(Car.numberOfCar);
        Car car2 = new Car("Mazda 6","Skyactiv 6");
        System.out.println(Car.numberOfCar);
    }
}
