package ss3_array_function.function.bai_tap;

import java.util.Scanner;

public class FindMaxInTwoDimensionalArray {
    public static void main(String[] args) {
        double[][] matrix = inputMatrix();
        double max = findMaxInTwoDimensionalArray(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == max) {
                    maxRow = i;
                    maxCol = j;
                    break;
                }
            }
        }
        System.out.println("Max element of the matrix is: " + max + ",which is on the row " + (maxRow + 1) + " and column " + (maxCol + 1));
    }

    public static double findMaxInTwoDimensionalArray(double[][] matrix) {
        double max = 0;
        for (double[] row : matrix) {
            for (double col : row) {
                if (col > max) {
                    max = col;
                }
            }
        }
        return max;
    }

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
