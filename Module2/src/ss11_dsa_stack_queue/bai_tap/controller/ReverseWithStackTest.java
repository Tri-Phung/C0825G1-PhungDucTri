package ss11_dsa_stack_queue.bai_tap.controller;

import ss11_dsa_stack_queue.bai_tap.entity.ReverseWithStack;

public class ReverseWithStackTest {
    static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Before reverse:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        ReverseWithStack.reverse(arr);
        System.out.println("After reverse:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
