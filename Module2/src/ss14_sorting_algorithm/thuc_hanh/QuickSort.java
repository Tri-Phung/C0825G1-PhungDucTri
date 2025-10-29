package ss14_sorting_algorithm.thuc_hanh;

public class QuickSort {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static void main() {
        quickSort(list,0,list.length-1);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] list, int start, int end) {
        if (end <= start) return;
//        int pivot = partition(list, start, end);
//        quickSort(list, start, pivot - 1);
//        quickSort(list, pivot + 1, end);
        int pivot = partitionHoare(list, start, end);
        quickSort(list,start,pivot);
        quickSort(list,pivot+1,end);
    }
    private static int partition(int[] list, int start, int end) {
        int  pivot = list[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (list[j] < pivot) {
                i++;
                swap(list, i, j);
            }
        }
        i++;
        swap(list, i, end);
        return i;
    }

    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static int partitionHoare(int[] list, int start, int end) {
        int pivot = list[start];
        int i = start - 1, j = end + 1;
        while (true) {
            do {
                ++i;
            } while (list[i] < pivot);
            do {
                --j;
            } while (list[j] > pivot);
            if (i < j) {
                swap(list, i, j);
            }
            else return j;
        }
    }
}
