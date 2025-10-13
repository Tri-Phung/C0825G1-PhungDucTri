package ss3_array_function.function.bai_tap;

import java.util.Scanner;

public class FindMaxInTwoDimensionalArray {
    public static void main(String[] args) {
        double[][] matrix = CommonUtils.inputMatrix();
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
}
