package ss7_abstract_class_interface.thuc_hanh.entity;

import ss6_inheritance.thuc_hanh.entity.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    @Override
    public int compareTo(ComparableCircle o) {
        return Double.compare(getRadius(), o.getRadius());
    }

    public ComparableCircle() {
    }
    public ComparableCircle(double radius) {
        super(radius);
    }
    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
}
