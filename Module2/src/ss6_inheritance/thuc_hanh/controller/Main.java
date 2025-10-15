package ss6_inheritance.thuc_hanh.controller;

import ss6_inheritance.thuc_hanh.entity.Shape;
import ss6_inheritance.thuc_hanh.entity.Circle;
import ss6_inheritance.thuc_hanh.entity.Rectangle;

public class Main {
    static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);

    }
}
