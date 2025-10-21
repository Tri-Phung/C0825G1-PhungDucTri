package ss10_dsa_list.thuc_hanh.entity;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public void add(E e) {
        if (size == elements.length) {
            enSureCapa();
        }
        elements[size++] = e;
    }
    public void enSureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public E get(int i) {
        if (i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return (E) elements[i];
    }
}