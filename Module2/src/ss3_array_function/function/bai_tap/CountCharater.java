package ss3_array_function.function.bai_tap;

import java.util.Random;
import java.util.Scanner;

public class CountCharater {
    public static void main(String[] args) {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        System.out.println("This is your random String: " + generatedString);
        int count = 0;
        char[] arr = generatedString.toCharArray();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character to count: ");
        char character = sc.next().charAt(0);
        for (char c : arr) {
            if (c == character) count++;
        }
        System.out.println("Number of " + character + " is " + count);
    }
}
