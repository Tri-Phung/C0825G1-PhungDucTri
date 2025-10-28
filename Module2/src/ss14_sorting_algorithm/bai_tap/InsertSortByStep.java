package ss14_sorting_algorithm.bai_tap;

public class InsertSortByStep {
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
            System.out.println("Step " + i + ": ");
            printArray(list);
        }
    }

    private static void printArray(int[] list) {
        for (int k : list) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    static void main() {
        System.out.println("Before sorting:");
        printArray(arr);
        System.out.println("Sorting...");
        insertSort(arr);
        System.out.println("After sorting:");
        printArray(arr);
    }
}
