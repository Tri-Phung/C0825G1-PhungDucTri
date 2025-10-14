package ss5_access_modifier.bai_tap.controller;

import ss5_access_modifier.bai_tap.entity.Circle;
import ss5_access_modifier.bai_tap.entity.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Test Circle
        Circle circle = new Circle(10);
        System.out.println("Radius of circle: " + circle.getRadius());
        System.out.println("Area of circle: " + circle.getArea());
        //Test Student
        Student student = new Student();
        student.setName("Tri Phung");
        student.setClasses("C0825G1");
    }
}
