package ss7_abstract_class_interface.thuc_hanh.controller;

import ss6_inheritance.thuc_hanh.entity.Circle;
import ss7_abstract_class_interface.thuc_hanh.entity.*;
import ss7_abstract_class_interface.thuc_hanh.service.*;

import java.util.Arrays;
import java.util.Comparator;


public class Main {
    static void main(String[] args) {
        // Lớp Animal và interface Edible (v.2023)
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Apple();
        fruits[1] = new Orange();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
        // triển khai interface 'Comparable' cho các lớp hình học (v.2023)
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5,"indigo", false);
        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("Sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        System.out.println("---------------------------------------------------------");
        Circle[] circles1 = new Circle[3];
        circles1[0] = new Circle(3.6);
        circles1[1] = new Circle();
        circles1[2] = new Circle(3.5,"indigo",false);
        System.out.println("Pre-sorted:");
        for (Circle circle : circles1) {
            System.out.println(circle);
        }
        Comparator circleComparator = new ComparatorCircle();
        Arrays.sort(circles1, circleComparator);
        System.out.println("Sorted:");
        for (Circle circle : circles1) {
            System.out.println(circle);
        }
    }
}
