package ss6_inheritance.bai_tap.entity;

import ss6_inheritance.thuc_hanh.entity.Shape;

public class Circle extends Shape {
    private double radius;
    private String color;
    public Circle() {
    }
    public Circle(double r, String c) {
        radius = r;
        color = c;
    }

    public Circle(double r) {
    }

    public Circle(double radius, String color, boolean filled ) {
        super(color, filled);
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
