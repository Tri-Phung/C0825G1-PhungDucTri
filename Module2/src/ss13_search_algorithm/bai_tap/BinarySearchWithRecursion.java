package ss13_search_algorithm.bai_tap;


import java.util.ArrayList;

public class BinarySearchWithRecursion {
    static void main() {
        int[] arr = {10,20,11,22,3,4,12,11,90,1,2,24,8,15};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        list.sort(null);
        System.out.println(list);
        int value = 10;
        int left = 0;
        int right = arr.length - 1;
        int index = binarySearch(list, left, right, value);
        if (index == -1) {
            System.out.println("Not found");
        } else {
            System.out.println("Found at index " + index);
        }
    }
    public static int binarySearch(ArrayList<Integer> array, int left, int right, int value) {
        if (left > right) return -1;
        int middle = (left + right)/2;
        if (array.get(middle) == value) {
            return middle;
        } else if (array.get(middle) > value) {
            return binarySearch(array, left, middle - 1, value);
        } else {
            return binarySearch(array, middle + 1, right, value);
        }
    }
}
