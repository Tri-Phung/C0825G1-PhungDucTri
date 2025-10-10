package ss2_loop_in_java.thuc_hanh.interest_rate;

import java.util.Scanner;

public class CountInterestRate {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter deposit: ");
            double deposit = sc.nextDouble();
            System.out.print("Enter interest rate: ");
            double interestRate = sc.nextDouble();
            System.out.print("Enter month: ");
            int month = sc.nextInt();
            System.out.print("Interest: " + countInterest(deposit, interestRate, month));
        }
        catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    private static double countInterest(double deposit, double interestRate, int month) {
        double total = 0;
        for (int i = 0; i<month; i++) {
            total += deposit * (interestRate/100)/12 * month;
        }
        return  total;
    }
}
