package case_study_accu.common.Validate;

import java.util.Scanner;

public class Validate {
    public static int inputInteger(String mess) {
        Scanner scanner = new Scanner(System.in);
        int temp;
        while (true) {
            try {
                System.out.print("Input "+mess+": ");
                temp = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(mess+" must  be an integer");
            } catch (Exception e) {
                System.out.println("Unexpected Error, please try again");
            }
        }
        return temp;
    }
}
