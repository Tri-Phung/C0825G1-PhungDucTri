package ss3_array_function.array.thuc_hanh.find_max;

import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        int size;
        int[] arr;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = sc.nextInt();
            if (size > 20) System.out.println("Size must less than 20");
        } while (size > 20);
        arr = new int[size];
        for (int i=0; i<size; i++) {
            System.out.print("Enter element " + (i+1) + ":");
            arr[i] = sc.nextInt();
        }
        System.out.print("Property list: ");
        for (int i=0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }
        int max = arr[0];
        int index = 0;
        for (int i=0; i<size; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i+1;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
