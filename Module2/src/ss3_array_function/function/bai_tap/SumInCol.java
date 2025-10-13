package ss3_array_function.function.bai_tap;

import java.util.Scanner;

public class SumInCol {
    public static void main(String[] args) {
        double[][] matrix = CommonUtils.inputMatrix();
        double sum = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the column number you want to sum: ");
                int col = Integer.parseInt(sc.nextLine());
                if (col < 0 || col >= matrix[0].length) {
                    System.out.println("Column number is out of range");
                    continue;
                }
                for (double[] row : matrix) {
                    sum += row[col];
                }
                System.out.println("Sum in column " + col + " is " + sum);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }
}
