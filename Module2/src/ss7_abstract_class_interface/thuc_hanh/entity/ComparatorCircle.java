package ss7_abstract_class_interface.thuc_hanh.entity;

import ss6_inheritance.thuc_hanh.entity.Circle;

import java.util.Comparator;

public class ComparatorCircle implements Comparator<Circle>{
    @Override
    public int compare(Circle o1, Circle o2) {
        return Double.compare(o1.getRadius(), o2.getRadius());
    }
}
