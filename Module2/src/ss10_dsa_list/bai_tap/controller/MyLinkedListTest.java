package ss10_dsa_list.bai_tap.controller;

import ss10_dsa_list.bai_tap.entity.MyLinkedList;

public class MyLinkedListTest {
    static void main(String[] args) {
        MyLinkedList<Integer> listInteger = new MyLinkedList<Integer>();
        //Appends the specified element to the end of this list
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        System.out.println(listInteger);
        // add an element at a specific position
        listInteger.add(2,6);
        System.out.println("After insert element 6 at index 2: \n" + listInteger);
        // add an element to the head
        listInteger.addFirst(7);
        System.out.println("After insert element 7 to the head: \n" + listInteger);
        // add an element to the tail
        listInteger.addLast(3);
        System.out.println("After insert element 3 to the tail: \n" + listInteger);
        // remove element at a specific position
        listInteger.remove(3);
        System.out.println("After delete element at index 3: \n" + listInteger);
        // remove a specific element at the first time occurrence
        listInteger.remove(listInteger.indexOf(3));
        System.out.println("After delete the first element 3: \n" + listInteger);
        // size of the list
        System.out.println("Size of the list: " + listInteger.size());
        // clone the list
        System.out.println("Clone the list: \n" + listInteger.clone());
        // check if the element is in the list
        System.out.println("Contains element 3: " + listInteger.contains(3));
        // get the element index
        System.out.println("Index of element 3: " + listInteger.indexOf(3));
        // get the element at a specific position
        System.out.println("Element at index 2: " + listInteger.get(2));
        System.out.println("Element at head: " + listInteger.getFirst());
        System.out.println("Element at tail: " + listInteger.getLast());
        // clear the list
        listInteger.clear();
        System.out.println("After clear: \n" + listInteger);
    }
}