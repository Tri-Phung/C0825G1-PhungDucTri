package ss14_sorting_algorithm.thuc_hanh;

import java.util.Scanner;

public class BubbleSortByStep {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter list size:");
        int size = sc.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + size + " values:");
        for (int i = 0; i < size; i++) {
            list[i] = sc.nextInt();
        }
        System.out.println("Your input list: ");
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        System.out.println("Sorting...");
        bubbleSortByStep(list);
        System.out.println("Sorted list: ");
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
    }
    public static void bubbleSortByStep(int[] arr) {
        boolean swapped = true;
        int size = arr.length;
        for (int i = 0; i < size-1 && swapped; i++) {
            swapped = false;
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    System.out.println("Swapping " + arr[j] + " with " + arr[j+1]);
                    swap(arr, j);
                    swapped = true;
                }
            }
        }
    }

    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j +1];
        arr[j +1] = temp;
    }
}
