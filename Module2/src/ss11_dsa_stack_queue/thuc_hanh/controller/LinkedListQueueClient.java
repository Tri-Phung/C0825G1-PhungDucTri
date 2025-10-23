package ss11_dsa_stack_queue.thuc_hanh.controller;

import ss11_dsa_stack_queue.thuc_hanh.entity.MyLinkedListQueue;
import ss11_dsa_stack_queue.thuc_hanh.entity.Node;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue);
        System.out.println("Dequeue item is " + queue.dequeue().key);
        System.out.println(queue);
    }
}
