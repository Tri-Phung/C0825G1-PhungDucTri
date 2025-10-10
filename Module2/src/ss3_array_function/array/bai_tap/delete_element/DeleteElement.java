package ss3_array_function.array.bai_tap.delete_element;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.print("Your array: ");
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the value you want to delete: ");
                int value = Integer.parseInt(sc.nextLine());
                boolean found = false;
                for (int k : arr) {
                    if (k == value) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Value not found in array.");
                } else {
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] == value) {
                            for (int j = i; j < arr.length - 1; j++) {
                                arr[j] = arr[j + 1];
                            }
                            arr[arr.length - 1] = 0;
                        }
                    }
                    System.out.print("New array: ");
                    for (int element : arr) {
                        System.out.print(element + " ");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input should be integer");
            }
        }
    }
}
