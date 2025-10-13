package ss4_class_and_object.bai_tap.stop_watch;

import java.util.Random;

public class SelectionSort100K {
    static void main(String[] args) {
        int n = 100000;
        int[] arr = new int[n];
        Random random = new Random();
        for (int i=0; i<n; i++) {
            arr[i] = random.nextInt(123456);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        selectionSort(arr);
        stopWatch.stop();
        System.out.println("Elapsed time: " + stopWatch.getElapsedTime() + " ms");
    }
    public static void selectionSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
