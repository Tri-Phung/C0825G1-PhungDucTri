package ss9_automated_test_tdd.bai_tap.entity;

public class TriangleClassification {
    public TriangleClassification() {
    }
    public String classify(double a, double b, double c) {
        if (a==0 || b==0 || c==0) {
            return "không phải là tam giác";
        }
        else if (a==b && b==c) {
            return "tam giác đều";
        }
        else if (a==b || b==c || a==c) {
            return "tam giác cân";
        }
        else if (a+b>c && b+c>a && c+a>b) {
            return "tam giác thường";
        }
        else {
            return "không phải là tam giác";
        }
    }
}
