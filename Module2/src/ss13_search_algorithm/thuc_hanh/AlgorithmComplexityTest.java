package ss13_search_algorithm.thuc_hanh;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = sc.nextLine();
        int[] frequentChar = new int[255];
        for (int i = 0; i < inputString.length(); i++) {
            int ascii = (int) inputString.charAt(i);
            frequentChar[ascii]++;
        }
        int max = 0;
        char charater = (char) 255;
        for (int j = 0; j < 255; j++) {
            if (frequentChar[j] > max) {
                max = frequentChar[j];
                charater = (char) j;
            }
        }
        System.out.println("The most appearing letter is '" + charater + "' with a frequency of " + max + "times");
    }
}
