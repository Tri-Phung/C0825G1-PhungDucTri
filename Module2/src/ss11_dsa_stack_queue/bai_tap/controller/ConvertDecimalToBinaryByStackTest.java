package ss11_dsa_stack_queue.bai_tap.controller;

import java.util.Stack;
import ss11_dsa_stack_queue.bai_tap.entity.ConvertDecimalToBinaryByStack;

public class ConvertDecimalToBinaryByStackTest {
    static void main(String[] args) {
        Stack<Integer> stack = ConvertDecimalToBinaryByStack.convertToBinary(30);
        System.out.println("The binary value of 30 is:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
