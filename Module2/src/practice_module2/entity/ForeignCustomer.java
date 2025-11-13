package practice_module2.entity;

public class ForeignCustomer extends Customer {
    private String nationality;

    public ForeignCustomer() {
    }

    @Override
    public double calculateBill(double amount, double price) {
        return amount * price;
    }

    public ForeignCustomer(String customerCode, String customerName, String nationality) {
        super(customerCode, customerName);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    @Override
    public String toString() {
        return "ForeignCustomer{" +
                "nationality='" + nationality + '\'' +
                '}';
    }
}
