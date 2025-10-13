package ss4_class_and_object.bai_tap.quadratic_equation;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter a, b, c: ");
                String line = sc.nextLine();
                String[] arr = line.split(" ");
                if (arr.length != 3) {
                    System.out.println("Invalid input");
                } else {
                    double a = Double.parseDouble(arr[0]);
                    double b = Double.parseDouble(arr[1]);
                    double c = Double.parseDouble(arr[2]);
                    QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
                    System.out.println(quadraticEquation.display());
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input type");
            }
        }
    }
}
