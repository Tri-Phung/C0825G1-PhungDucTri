package ss3_array_function.function.bai_tap;

public class DiagonalSum {
    public static void main(String[] args) {
        double[][] matrix;
        while(true) {
            matrix = CommonUtils.inputMatrix();
            if (matrix.length != matrix[0].length) {
                System.out.println("The matrix is not square!");
                continue;
            }
            break;
        }
        double sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        System.out.println("The diagonal sum of the matrix is: " + sum);
    }
}
