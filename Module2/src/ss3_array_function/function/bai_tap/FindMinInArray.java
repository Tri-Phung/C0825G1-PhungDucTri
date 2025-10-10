package ss3_array_function.function.bai_tap;

import java.util.Scanner;

public class FindMinInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                System.out.println("Choose what you want to do below:");
                System.out.println("1. Create a available array");
                System.out.println("2. Create an array by typing");
                System.out.print("Enter your choice:");
                choice = Integer.parseInt(sc.nextLine());
                if (choice < 1 || choice > 2) {
                    System.out.println("Invalid choice");
                    continue;
                }
                switch (choice) {
                    case 1:
                        int[] array = new int[10];
                        for (int i = 0; i < array.length; i++) {
                            array[i] = (int) (Math.random() * 100);
                        }
                        System.out.println("Your array: ");
                        for (int j : array) {
                            System.out.print(j + " ");
                        }
                        System.out.println();
                        System.out.println("Min value is: " + minValue(array));
                        break;
                    case 2:
                        inputArray();
                        break;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void inputArray() {
        Scanner sc = new Scanner(System.in);
        int size;
        while (true) {
            try {
                System.out.print("Enter the size of your array: ");
                size = Integer.parseInt(sc.nextLine());
                int[] arr = new int[size];
                for (int i = 0; i < arr.length; i++) {
                    System.out.print("Enter the element " + i + ":");
                    arr[i] = Integer.parseInt(sc.nextLine());
                }
                System.out.println("Your array: ");
                for (int j : arr) {
                    System.out.print(j + " ");
                }
                System.out.println();
                System.out.println("Min value is: " + minValue(arr));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }
}
