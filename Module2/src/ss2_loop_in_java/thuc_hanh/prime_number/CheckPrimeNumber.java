package ss2_loop_in_java.thuc_hanh.prime_number;

import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        if (isPrime(number)) System.out.println(number + " is a prime number");
        else System.out.println(number + " is not a prime number");
    }
    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number%i == 0) return false;
        }
        return true;
    }
}
