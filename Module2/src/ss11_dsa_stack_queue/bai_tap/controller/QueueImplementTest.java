package ss11_dsa_stack_queue.bai_tap.controller;

import ss11_dsa_stack_queue.bai_tap.entity.Solution;
import ss11_dsa_stack_queue.bai_tap.entity.Queue;

import java.util.Arrays;

public class QueueImplementTest {
    static void main(String[] args) {
        Queue queue = new Queue();
        Solution solution = new Solution();
        solution.enQueue(queue, 1);
        solution.enQueue(queue, 2);
        solution.enQueue(queue, 3);
        solution.enQueue(queue, 4);
        solution.enQueue(queue, 5);
        solution.displayQueue(queue);
        solution.deQueue(queue);
        System.out.println( "After 1st deQueue: ");
        solution.displayQueue(queue);
        solution.deQueue(queue);
        System.out.println( "After 2nd deQueue: ");
        solution.displayQueue(queue);
        solution.enQueue(queue, 6);
        System.out.println( "After enQueue value 6: ");
        solution.displayQueue(queue);
    }
}
