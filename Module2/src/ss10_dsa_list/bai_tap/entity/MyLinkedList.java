package ss10_dsa_list.bai_tap.entity;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;
    public MyLinkedList(){
        head = null;
        numNodes = 0;
    }
    public boolean add(E e) {
        addLast(e);
        return true;
    }
    public void add(int index, E element) {
        Node previous = head;
        Node current;
        for (int i = 0; i < index-1 && previous.next != null ; i++) {
            previous = previous.next;
        }
        current = previous.next;
        previous.next = new Node(element);
        previous.next.next = current;
        numNodes++;
    }
    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
    }
    public void addLast(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            numNodes++;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        numNodes++;
    }
    public E remove(int index) {
        Node previous = head;
        Node current;
        for (int i = 0; i < index-1 && previous.next != null ; i++) {
            previous = previous.next;
        }
        current = previous.next;
        previous.next = current.next;
        numNodes--;
        return (E) current.data;
    }
    public boolean remove(Object e) {
        Node previous = head;
        Node current;
        while (previous.next != null) {
            current = previous.next;
            if (current.data.equals(e)) {
                previous.next = current.next;
                numNodes--;
                return true;
            }
        }
        return false;
    }
    public int size() {
        return numNodes;
    }
    public E clone() {
        MyLinkedList<E> cloneLinkedList = new MyLinkedList<>();
        Node current = head;
        while (current != null) {
            cloneLinkedList.addLast((E) current.data);
            current = current.next;
        }
        return (E) cloneLinkedList;
    }
    public boolean contains(E o) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int indexOf(E o) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }
    public E get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (E) current.data;
    }
    public E getFirst() {
        return (E) head.data;
    }
    public E getLast() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return (E) current.data;
    }
    public void clear() {
        head = null;
        numNodes = 0;
    }
    public String printList() {
        Node current = head;
        StringBuilder list = new StringBuilder();
        while (current != null) {
            list.append(current.data);
            if (current.next != null) list.append(" -> ");
            current = current.next;
        }
        return list.toString();
    }
    @Override
    public String toString() {
        return "MyLinkedList{" +
                "numNodes=" + numNodes +
                ", list=" + printList() +
                '}';
    }

    class Node {
        private Object data;
        private Node next;
        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return data;
        }
    }
}
