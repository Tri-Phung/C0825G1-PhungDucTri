package ss13_search_algorithm.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class LongestIncreaseSubstringContinuous {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        LinkedList<Character> LongestIncreaseString = findLongestIncreaseSubStringContinuous(str);
        for (Character c : LongestIncreaseString) {
            System.out.print(c);
        }
    }
    private static LinkedList<Character> findLongestIncreaseSubStringContinuous(String str) {
        LinkedList<Character> increaseSubstring = new LinkedList<>();
        LinkedList<Character> longestSubstring = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if (increaseSubstring.isEmpty() || increaseSubstring.getLast() < str.charAt(i)) {
                increaseSubstring.add(str.charAt(i));
            }
            else {
                if (longestSubstring.size() < increaseSubstring.size()) {
                    longestSubstring.clear();
                    longestSubstring.addAll(increaseSubstring);
                }
                increaseSubstring.clear();
                increaseSubstring.add(str.charAt(i));
            }
        }
        if (longestSubstring.size() < increaseSubstring.size()) {
            longestSubstring.clear();
            longestSubstring.addAll(increaseSubstring);
        }
        return longestSubstring;
    }
}
