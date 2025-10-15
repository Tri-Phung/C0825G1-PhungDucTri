package ss4_class_and_object.bai_tap.quadratic_equation;

class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation() {

    }
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }
    public double getRoot1() {
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }
    public double getRoot2() {
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }
    public String display() {
        if (getDiscriminant() > 0) {
            return "The equation has two roots: " + getRoot1() + " and " + getRoot2();
        } else if (getDiscriminant() == 0) {
            return "The equation has one root: " + (-b) / (2 * a);
        }
        return "The equation has no roots.";
    }
}
