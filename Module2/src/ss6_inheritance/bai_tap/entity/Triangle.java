package ss6_inheritance.bai_tap.entity;

import ss6_inheritance.thuc_hanh.entity.Shape;

public class Triangle extends Shape{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color,filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getArea() {
        double heron = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(heron * (heron - this.side1) * (heron - this.side2) * (heron - this.side3));
    }
    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public boolean isTriangle() {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }

    @Override
    public String toString() {
        String fillStatus = super.isFilled() ? "filled" : "not filled";
        if (!isTriangle()) {
            return "Triangle is not a triangle";
        }
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                ", color='" + super.getColor() + '\'' +
                ", filled=" + fillStatus +
                '}';
    }
}
