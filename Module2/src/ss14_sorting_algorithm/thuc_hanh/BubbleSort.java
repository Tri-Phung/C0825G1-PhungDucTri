package ss14_sorting_algorithm.thuc_hanh;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        for (int i = 0; i < list.length - 1 && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j] > list[j + 1]) {
                    swap(list, j);
                    needNextPass = true;
                }
            }
        }
    }

    private static void swap(int[] list, int j) {
        int temp = list[j];
        list[j] = list[j + 1];
        list[j + 1] = temp;
    }

    static void main() {
        bubbleSort(list);
        for (int j : list) {
            System.out.print(j + " ");
        }
    }
}
