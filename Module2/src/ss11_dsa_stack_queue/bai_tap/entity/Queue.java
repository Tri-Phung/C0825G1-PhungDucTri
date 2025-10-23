package ss11_dsa_stack_queue.bai_tap.entity;

import java.util.NoSuchElementException;

public class Queue {
    private Node front;
    private Node rear;
    public Queue() {
        front = null;
        rear = null;
    }

    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getRear() {
        return rear;
    }

    public void setRear(Node rear) {
        this.rear = rear;
    }
}
