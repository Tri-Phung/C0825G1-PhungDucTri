import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vnd = 26361.02;
        double usd = 1;
        System.out.print("Enter the amount of USD: ");
        double usdAmount = scanner.nextDouble();
        double result = usdAmount * vnd;
        System.out.println(usdAmount + " USD = " + result + " VND");
    }
}
