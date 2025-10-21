package ss10_dsa_list.thuc_hanh.entity;

public class MyLinkedList {
    private Node head;
    private int numNodes;
    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }
    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index-1 && temp.next != null ; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }
    }
    class Node {
        private Object data;
        private Node next;
        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }
    }
}
