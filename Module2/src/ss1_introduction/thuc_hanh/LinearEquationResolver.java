package ss1_introduction.show_datetime;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b:");
        double b = scanner.nextDouble();
        System.out.print("Enter c:");
        double c = scanner.nextDouble();
        double x = (c - b)/a;
        if (a != 0) {
            System.out.println("x = " + x);
        }
        else {
            if (b == c) {
                System.out.println("countless solutions");
            }
            else
                System.out.println("no solution");
        }
    }
}
