package practice_module2.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Bill {
    private static int billCodeCount = 0;
    private String billCode;
    private String customerCode;
    private LocalDate billDate;
    private double amount;
    private double price;
    private double total;

    public Bill() {
    }
    public Bill(String customerCode, LocalDate billDate, double amount, double price) {
        this.billCode = String.format("MHD-%03d", ++billCodeCount);
        this.customerCode = customerCode;
        this.billDate = billDate;
        this.amount = amount;
        this.price = price;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public void calculateTotal(Customer customer) {
        setTotal(customer.calculateBill(getAmount(), getPrice()));
    }
    @Override
    public String toString() {
        return "Bill{" +
                "billCode='" + billCode + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", billDate=" + billDate +
                ", amount=" + amount +
                ", price=" + price +
                ", total=" + total +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Double.compare(amount, bill.amount) == 0 && Double.compare(price, bill.price) == 0 && Double.compare(total, bill.total) == 0 && Objects.equals(billCode, bill.billCode) && Objects.equals(customerCode, bill.customerCode) && Objects.equals(billDate, bill.billDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billCode, customerCode, billDate, amount, price, total);
    }
}
