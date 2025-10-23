package ss11_dsa_stack_queue.bai_tap.entity;

import java.util.Stack;

public class ConvertDecimalToBinaryByStack {
    public static Stack<Integer> convertToBinary(int decimalValue) {
        Stack<Integer> stack = new Stack<>();
        while (decimalValue != 0) {
            stack.push(decimalValue % 2);
            decimalValue /= 2;
        }
        return stack;
    }
}
