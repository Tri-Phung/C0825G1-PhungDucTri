package ss6_inheritance.thuc_hanh.entity;

public class Circle extends Shape {
    private double radius = 1.0;
    public Circle() {
    }
    public Circle(double r) {
        radius = r;
    }
    public Circle(double r, String color, boolean filled) {
        super(color,filled);
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }
}
