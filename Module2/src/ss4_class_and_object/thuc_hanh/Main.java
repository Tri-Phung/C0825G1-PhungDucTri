package ss4_class_and_object.thuc_hanh;

import ss3_array_function.function.bai_tap.SumInCol;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter width:");
        double width = sc.nextDouble();
        System.out.println("Enter height:");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your rectangle: " + rectangle.display());
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());
    }
}
