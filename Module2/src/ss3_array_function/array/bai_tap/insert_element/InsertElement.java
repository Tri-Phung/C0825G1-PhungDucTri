package ss3_array_function.array.bai_tap.insert_element;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int randomLength= (int) (Math.random() * arr.length);
        for (int i = 0; i < randomLength; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.print("Your array: ");
        for (int element: arr) {
            System.out.print(element + " ");
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value you want to insert: ");
        try {
            int value = sc.nextInt();
            System.out.print("Enter the index you want to insert: ");
            int index = sc.nextInt();
            if (index < 0 || index > arr.length-1) {
                System.out.println("Index is out of range");
                return;
            }
            if (randomLength == arr.length) {
                System.out.println("There no more space for inserting");
                return;
            }
            if (arr[arr.length-1] !=0 && index == arr.length-1) {
                System.out.println("There no more space for inserting");
            }
            else {
                if (index == 0) {
                    for (int i = arr.length-1; i > 0; i--) {
                        arr[i] = arr[i-1];
                    }
                    arr[0] = value;
                    System.out.print("New array: ");
                    for (int element: arr) {
                        System.out.print(element + " ");
                    }
                }
                else if (arr[index] == 0) {
                    arr[index] = value;
                    System.out.print("New array: ");
                    for (int element: arr) {
                        System.out.print(element + " ");
                    }
                }
                else {
                    for (int i = 0; i < arr.length; i++) {
                        if (i == index) {
                            for (int j = arr.length - 1; j >= index; j--) {
                                arr[j] = arr[j-1];
                            }
                            arr[index] = value;
                            System.out.print("New array: ");
                            for (int element: arr) {
                                System.out.print(element + " ");
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input");
        }

    }
}
