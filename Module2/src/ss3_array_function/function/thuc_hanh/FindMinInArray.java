package ss3_array_function.function.thuc_hanh;

public class FindMinInArray {
    public static void main(String[] args) {
        System.out.println("The smallest element in the array is: " + minValue(new int[]{4, 12, 7, 8, 1, 6, 9}));
    }

    public static int minValue(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
