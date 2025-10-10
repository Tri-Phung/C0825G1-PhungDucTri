package ss3_array_function.function.thuc_hanh;

import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        int choice = -1;
        double f = 0;
        double c = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                do {
                    System.out.println("Menu");
                    System.out.println("1. Fahrenheit to Celsius");
                    System.out.println("2. Celsius to Fahrenheit");
                    System.out.println("0. Exit");
                    System.out.println("Enter your choice: ");
                    choice = Integer.parseInt(input.nextLine());
                    switch (choice) {
                        case 1:
                            System.out.println("Input Fahrenheit");
                            f = Double.parseDouble(input.nextLine());
                            System.out.println("Fahrenheit to Celsius: " + FtoC(f));
                            break;
                        case 2:
                            System.out.println("Input Celsius");
                            c = Double.parseDouble(input.nextLine());
                            System.out.println("Celsius to Fahrenheit: " + CtoF(f));
                            break;
                        case 0:
                            System.out.println("Thank you for using this program");
                    }
                }
                while (choice != 0);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input invalid");
            }
        }
    }

    public static double FtoC(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    public static double CtoF(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }
}
