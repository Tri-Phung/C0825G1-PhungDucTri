package ss10_dsa_list.thuc_hanh.controller;

import ss10_dsa_list.thuc_hanh.entity.MyLinkedList;

public class MyLinkedListTest {
    static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.add(4,9);
        ll.add(4,9);
        ll.printList();
    }
}
