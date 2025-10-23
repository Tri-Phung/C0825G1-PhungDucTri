package ss11_dsa_stack_queue.bai_tap.entity;

import java.util.Stack;

public class ReverseWithStack {
    public static void reverse(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int j : arr) {
            stack.push(j);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }
}
