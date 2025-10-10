package ss3_array_function.array.thuc_hanh.search_array;

import java.util.Scanner;

public class SearchArray {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a student name: ");
        String name = sc.nextLine();
        for (int i=0; i<students.length; i++) {
            if (students[i].equals(name)) {
                System.out.println(name + " was found at index " + i + ".");
                return;
            }
        }
        System.out.println(name + " was not found.");
    }
}
