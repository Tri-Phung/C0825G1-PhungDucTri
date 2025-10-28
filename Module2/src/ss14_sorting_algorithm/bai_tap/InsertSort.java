package ss14_sorting_algorithm.bai_tap;

public class InsertSort {
    static int[] arr = {10,20,11,22,3,4,12,11,90,1,2,24,8,15};
    public static void insertSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i-1;
            while (j >= 0 && list[j] > key) {
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = key;
        }
    }

    static void main() {
        System.out.println("Before: ");
        printArr();
        insertSort(arr);
        System.out.println("After: ");
        printArr();
    }

    private static void printArr() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
