package ss1_introduction.bai_tap.currency;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vnd = 26361.02;
        double usd = 1;
        System.out.print("Enter the amount of USD: ");
        try {
            double usdAmount = scanner.nextDouble();
            if (usdAmount <= 0) {
                System.out.println("Amount must be positive");
                return;
            }
            double result = usdAmount * vnd;
            System.out.println(usdAmount + " USD = " + result + " VND");
        }
        catch (Exception e) {
            System.out.print("Invalid input");
        }
    }
}
