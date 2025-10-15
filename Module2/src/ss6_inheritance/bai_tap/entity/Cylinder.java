package ss6_inheritance.bai_tap.entity;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){}

    public Cylinder(double r, String c, double height) {
        super(r, c);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return this.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                ", radius=" + super.getRadius() +
                ", color='" + super.getColor() + '\'' +
                '}';
    }
}
