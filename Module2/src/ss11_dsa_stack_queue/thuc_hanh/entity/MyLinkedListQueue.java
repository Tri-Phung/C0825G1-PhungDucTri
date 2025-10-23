package ss11_dsa_stack_queue.thuc_hanh.entity;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;
    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }
    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }
    public Node dequeue() {
        if (this.head == null) {
            return null;
        }
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return temp;
    }
    public String printQueue() {
        Node current = this.head;
        StringBuilder list = new StringBuilder();
        while (current != null) {
            list.append(current.key);
            if (current.next != null) list.append(" -> ");
            current = current.next;
        }
        return list.toString();
    }
    @Override
    public String toString() {
        return "MyLinkedListQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", list=" + printQueue() +
                '}';
    }
}
