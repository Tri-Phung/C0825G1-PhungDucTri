package practice_module2.entity;

public class ClassificationCustomer {
    private String classificationCode;
    private String classificationName;

    public ClassificationCustomer(String classificationCode, String classificationName) {
        this.classificationName = classificationName;
        this.classificationCode = classificationCode;
    }

    public String getClassificationCode() {
        return classificationCode;
    }

    public void setClassificationCode(String classificationCode) {
        this.classificationCode = classificationCode;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    @Override
    public String toString() {
        return classificationCode + " - " + classificationName;
    }
}
