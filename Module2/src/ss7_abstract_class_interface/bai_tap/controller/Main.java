package ss7_abstract_class_interface.bai_tap.controller;

import ss7_abstract_class_interface.bai_tap.entity.*;
import ss7_abstract_class_interface.bai_tap.service.*;

public class Main {
    static void main(String[] args) {
        // Triển khai interface 'Resizeable' cho các lớp hình học
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(10, 5);
        shapes[1] = new Square(5);
        shapes[2] = new Circle(15);
        System.out.println("Before resize:");
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
        System.out.println("After resize:");
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                Resizeable resizeRectangle = (Rectangle) shape;
                resizeRectangle.resize(Math.random() * 101);
            } else if (shape instanceof Square) {
                Resizeable resizeSquare = (Square) shape;
                resizeSquare.resize(Math.random() * 101);
            } else if (shape instanceof Circle) {
                Resizeable resizeCircle = (Circle) shape;
                resizeCircle.resize(Math.random() * 101);
            }
        }
        System.out.println("-------------------------------------------------------");
        // triển khai interface 'Colorable' cho các lớp hình học
        for (Shape shape : shapes) {
            System.out.println(shape.toString() + ", Area=" + shape.getArea());
            if (shape instanceof Colorable colorable) {
                colorable.howToColor();
            }
        }
    }
}
