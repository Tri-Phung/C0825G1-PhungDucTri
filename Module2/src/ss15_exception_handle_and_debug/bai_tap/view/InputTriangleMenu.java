package ss15_exception_handle_and_debug.bai_tap.view;

import ss15_exception_handle_and_debug.bai_tap.common.exception.IllegalTriangleException;
import ss15_exception_handle_and_debug.bai_tap.common.validate.Validate;
import ss15_exception_handle_and_debug.bai_tap.controller.TriangleController;
import ss15_exception_handle_and_debug.bai_tap.entity.Triangle;

import java.util.Scanner;

public class InputTriangleMenu {
    private static TriangleController triangleController = new TriangleController();

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Input triangle");
        System.out.println("2. Exit");
        int choice = Validate.inputInteger("your choice");
        switch (choice) {
            case 1:
                Triangle triangle = inputTriangle();
                System.out.println(triangle.toString());
                break;
            case 2:
                System.out.println("Program terminated");
                return;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static Triangle inputTriangle() {
        Scanner sc = new Scanner(System.in);
        double side1;
        double side2;
        double side3;
        while (true) {
            try {
                side1 = Validate.inputDouble("side1");
                side2 = Validate.inputDouble("side2");
                side3 = Validate.inputDouble("side3");
                triangleController.isTriangle(side1, side2, side3);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e)  {
                System.out.println("Unexpected error");
            }
        }
        return new Triangle(side1, side2, side3);
    }
}
