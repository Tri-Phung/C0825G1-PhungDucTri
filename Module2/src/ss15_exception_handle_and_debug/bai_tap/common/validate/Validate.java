package ss15_exception_handle_and_debug.bai_tap.common.validate;


import java.util.Scanner;

public class Validate {
    public static double inputDouble(String input) {
        Scanner sc = new Scanner(System.in);
        double temp;
        while (true) {
            try {
                System.out.println("Enter " + input + ": ");
                temp = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("You should enter a number");
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        return temp;
    }
    public static int inputInteger(String input) {
        Scanner sc = new Scanner(System.in);
        int temp;
        while (true) {
            try {
                System.out.println("Enter " + input + ": ");
                temp = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("You should enter an integer number");
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
        return temp;
    }
}
