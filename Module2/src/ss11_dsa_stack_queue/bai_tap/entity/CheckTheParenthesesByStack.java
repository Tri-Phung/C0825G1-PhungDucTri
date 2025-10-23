package ss11_dsa_stack_queue.bai_tap.entity;

import java.util.Stack;

public class CheckTheParenthesesByStack {
    public static boolean checkParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            if (character == '(') {
                stack.push(character);
            }
            else if (character == ')') {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (left != '(') return false;
            }
        }
        return stack.isEmpty();
    }
}
