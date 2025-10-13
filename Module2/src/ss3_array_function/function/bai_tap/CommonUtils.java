package ss3_array_function.function.bai_tap;

import java.util.Scanner;

public class CommonUtils {
    public static double[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        int rows;
        int cols;
        double[][] matrix;
        while (true) {
            try {
                System.out.print("Enter the number of rows for the array:");
                rows = Integer.parseInt(sc.nextLine());
                if (rows <= 0) {
                    System.out.println("Rows must be greater than 0");
                    continue;
                }
                System.out.print("Enter the number of cols for the array:");
                cols = Integer.parseInt(sc.nextLine());
                if (cols <= 0) {
                    System.out.print("Columns must be greater than 0");
                    continue;
                }
                matrix = new double[rows][cols];
                for (int i = 0; i < rows; i++) {
                    System.out.println("Enter the elements for the row " + (i + 1) + ":");
                    for (int j = 0; j < cols; j++) {
                        System.out.print("Enter the elements for the column " + (j + 1) + ":");
                        matrix[i][j] = Double.parseDouble(sc.nextLine());
                    }
                }
                System.out.println("This is your matrix:");
                for (double[] i : matrix) {
                    for (double j : i) {
                        System.out.print(j + " ");
                    }
                    System.out.println();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
        return matrix;
    }
}
