package ss2_loop_in_java.thuc_hanh.gcd;

import java.util.Scanner;

public class CountGcd {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a:");
            double a = sc.nextDouble();
            System.out.print("Enter b:");
            double b = sc.nextDouble();
            System.out.print("gcd: "+gcd(a,b));
        }
        catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    private static double gcd(double a, double b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }
}
