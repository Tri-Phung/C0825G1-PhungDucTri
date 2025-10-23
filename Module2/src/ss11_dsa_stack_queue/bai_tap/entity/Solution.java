package ss11_dsa_stack_queue.bai_tap.entity;

import java.util.NoSuchElementException;

public class Solution {
    public void enQueue(Queue queue, int data) {
        Node newNode = new Node(data);
        if (queue.getRear() == null) {
            queue.setFront(newNode);
            queue.setRear(newNode);
            newNode.setLink(newNode);
            return;
        }
        newNode.setLink(queue.getFront());
        queue.getRear().setLink(newNode);
        queue.setRear(newNode);
    }
    public Node deQueue(Queue queue) {
        if (queue.getFront() == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        Node NodeToRemove = queue.getFront();
        if  (queue.getFront() == queue.getRear()) {
            queue.setFront(null);
            queue.setRear(null);
        }
        else {
            queue.setFront(queue.getFront().getLink());
            queue.getRear().setLink(queue.getFront());
        }
        return NodeToRemove;
    }
    public void displayQueue(Queue queue) {
        if (queue.getFront() == null) {
            System.out.println("NULL");
            return;
        }
        Node current = queue.getFront();
        System.out.print("Queue{ ");
        do {
            System.out.print(current.getData() + " -> ");
            current = current.getLink();
        } while (current != queue.getFront());
        System.out.println(queue.getRear().getLink().getData() + "(back to front) }");
    }
}
