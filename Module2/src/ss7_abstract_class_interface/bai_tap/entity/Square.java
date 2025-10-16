package ss7_abstract_class_interface.bai_tap.entity;

import ss7_abstract_class_interface.bai_tap.service.Colorable;
import ss7_abstract_class_interface.bai_tap.service.Resizeable;

public class Square extends Shape implements Resizeable, Colorable {
    private double side = 1.0;
    public Square() {
    }
    public Square(double s) {
        side = s;
    }
    public Square(double s, String color, boolean filled) {
        super(color,filled);
        side = s;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }
    public double getPerimeter() {
        return 4 * side;
    }
    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        double before = this.getArea();
        this.side *= (percent/100);
        System.out.println("Square: ");
        System.out.println("Area before resize: " + before + ", Area after resize: " + this.getArea());
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
