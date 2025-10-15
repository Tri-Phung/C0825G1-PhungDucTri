package ss6_inheritance.bai_tap.controller;

import ss6_inheritance.bai_tap.entity.Circle;
import ss6_inheritance.bai_tap.entity.Cylinder;
import ss6_inheritance.bai_tap.entity.Point2D;
import ss6_inheritance.bai_tap.entity.Point3D;
import ss6_inheritance.bai_tap.entity.Point;
import ss6_inheritance.bai_tap.entity.MovablePoint;
import ss6_inheritance.bai_tap.entity.Triangle;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        // Class Circle and Cylinder
        Circle circle = new Circle(1.0,"red");
        System.out.println(circle.toString());
        Circle cylinder = new Cylinder(2.0,"blue",1.0);
        System.out.println(cylinder.toString());
        System.out.println("----------------------------------------------");
        // Point2D and Point3D
        Point2D point2D = new Point2D(1,2);
        System.out.println(point2D.toString());
        Point2D point3D = new Point3D(3,4,5);
        System.out.println(point3D.toString());
        System.out.println("----------------------------------------------");
        // Point and MoveablePoint
        Point point = new Point(1,2);
        System.out.println(point.toString());
        MovablePoint movePoint = new MovablePoint(3,4,123,456);
        System.out.println(movePoint.toString());
        System.out.println("Move point:");
        System.out.println(movePoint.move());
        System.out.println("----------------------------------------------");
        // Triangle and Shape
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                System.out.println("Enter the length of side 1:");
                double side1 = Double.parseDouble(sc.nextLine());
                System.out.println("Enter the length of side 2:");
                double side2 = Double.parseDouble(sc.nextLine());
                System.out.println("Enter the length of side 3:");
                double side3 = Double.parseDouble(sc.nextLine());
                System.out.println("Enter the color of triangle:");
                String color = sc.nextLine();
                Triangle triangle = new Triangle(color,true,side1,side2,side3);
                System.out.println(triangle.toString());
                break;
            } catch(NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }
}
