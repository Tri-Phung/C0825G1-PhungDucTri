package ss3_array_function.array.bai_tap.merge_array;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 5 elements for the first array:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            arr1[i] = scanner.nextInt();
        }
        System.out.println("Type 5 elements for the second array:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            arr2[i] = scanner.nextInt();
        }
        int[] arr3 = new int[arr1.length + arr2.length];
        int index = 0;
        for (int j : arr1) {
            arr3[index++] = j;
        }
        for (int j : arr2) {
            arr3[index++] = j;
        }
        System.out.println("The merged array: ");
        for (int element: arr3) {
            System.out.print(element + " ");
        }
    }
}
