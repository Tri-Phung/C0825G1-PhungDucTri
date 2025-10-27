package ss13_search_algorithm.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class LongestIncreaseSubstring {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        LinkedList<Character> LongestIncreaseString = findLongestIncreaseSubString(str);
        for (Character c : LongestIncreaseString) {
            System.out.print(c);
        }
    }

    private static LinkedList<Character> findLongestIncreaseSubString(String str) {
        LinkedList<Character> longestSubstring = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if (longestSubstring.isEmpty() || longestSubstring.getLast() < str.charAt(i)) {
                longestSubstring.add(str.charAt(i));
            }
        }
        return longestSubstring;
    }
}
