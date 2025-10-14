package ss4_class_and_object.bai_tap.quadratic_equation;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        double a, b, c;
        while (true) {
            try {
                System.out.print("Enter a: ");
                a = Double.parseDouble(sc.nextLine());
                System.out.print("Enter b: ");
                b = Double.parseDouble(sc.nextLine());
                System.out.print("Enter c: ");
                c = Double.parseDouble(sc.nextLine());
                QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
                System.out.println(quadraticEquation.display());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input type");
            }
        }
    }
}
