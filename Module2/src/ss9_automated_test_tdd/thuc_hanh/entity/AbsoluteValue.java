package ss9_automated_test_tdd.thuc_hanh.entity;

public class AbsoluteValue {
    public static int returnAbsoluteValue(int value){
        if (value < 0) return -value;
        return value;
    }
}
