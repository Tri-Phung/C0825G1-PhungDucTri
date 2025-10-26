package ss12_map_tree.bai_tap.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = sc.nextLine();
        String[] words = sentence.split("[\\s;,.]");
        Map<String, Integer> mapWord = new TreeMap<>();
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            if (lowerCaseWord.isEmpty()) continue;
            if (mapWord.containsKey(lowerCaseWord)) {
                mapWord.put(lowerCaseWord, mapWord.get(lowerCaseWord)+1);
            }
            else mapWord.put(lowerCaseWord,1);
        }
        System.out.println("Result: ");
        for (Map.Entry<String, Integer> entryWord : mapWord.entrySet()) {
            System.out.println(entryWord.getKey() + " : " + entryWord.getValue());
        }
    }
}
