package ss10_dsa_list.bai_tap.controller;

import ss10_dsa_list.bai_tap.entity.MyList;

public class MyListTest {
    static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        //Appends the specified element to the end of this list
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        System.out.println("List Integer:");
        System.out.println(listInteger);
        //Removes the element at the specified position in this list
        listInteger.remove(2);
        System.out.println("After remove element 2:");
        System.out.println(listInteger);
        //Returns a shallow copy of this ArrayList instance
        System.out.println("Shallow copy:");
        System.out.println(listInteger.clone());
        //Returns true if this list contains the specified element
        System.out.println("Contains element 2: " + listInteger.contains(2));
        System.out.println("Contains element 6: " + listInteger.contains(6));
        //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
        System.out.println("Index of the first occurrence of element 2: " + listInteger.indexOf(2));
        System.out.println("Index of the first occurrence of element 6: " + listInteger.indexOf(6));
        //Inserts the specified element at the specified position in this list
        listInteger.add(2,6);
        System.out.println("After insert element 6 at index 2: \n" + listInteger);
        //Returns the element at the specified position in this list
        System.out.println("Element at index 3: " + listInteger.get(3));
        //Removes all of the elements from this list
        listInteger.clear();
        System.out.println("After clear: " + listInteger);
    }
}
