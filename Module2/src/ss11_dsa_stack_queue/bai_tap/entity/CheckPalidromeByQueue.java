package ss11_dsa_stack_queue.bai_tap.entity;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class CheckPalidromeByQueue {
    public static boolean isPalindrome(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.toLowerCase().charAt(i));
            queue.add(str.toLowerCase().charAt(i));
        }
        System.out.println(queue);
        System.out.println(stack);
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() != queue.remove()) {
                return false;
            }
        }
        return stack.isEmpty()&&queue.isEmpty();
    }
}
