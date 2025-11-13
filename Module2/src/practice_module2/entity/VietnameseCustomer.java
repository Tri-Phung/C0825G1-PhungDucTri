package practice_module2.entity;

public class VietnameseCustomer extends Customer {
    private String kindOfCustomer;
    private double comsumptionStandard;

    public VietnameseCustomer() {
    }

    @Override
    public double calculateBill(double amount, double price) {
        if (amount <= comsumptionStandard) {
            return amount * price;
        } else {
            return price *comsumptionStandard + (amount - comsumptionStandard) * price * 2.5;
        }
    }

    public VietnameseCustomer(String customerCode, String customerName, String kindOfCustomer, double comsumptionStandard) {
        super(customerCode, customerName);
        this.kindOfCustomer = kindOfCustomer;
        this.comsumptionStandard = comsumptionStandard;
    }

    public String getKindOfCustomer() {
        return kindOfCustomer;
    }

    public void setKindOfCustomer(String kindOfCustomer) {
        this.kindOfCustomer = kindOfCustomer;
    }

    public double getComsumptionStandard() {
        return comsumptionStandard;
    }

    public void setComsumptionStandard(double comsumptionStandard) {
        this.comsumptionStandard = comsumptionStandard;
    }
    @Override
    public String toString() {
        return "VietnameseCustomer{" +
                "kindOfCustomer='" + kindOfCustomer + '\'' +
                ", comsumptionStandard=" + comsumptionStandard +
                '}';
    }
}
