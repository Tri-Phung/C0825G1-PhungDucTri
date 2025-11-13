package practice_module2.service;

import practice_module2.entity.Bill;

import java.time.LocalDate;

public interface IBillService extends IService<Bill>{
    void editBill(String billCode, String customerCode);
    void editBill(String billCode, LocalDate billDate);
    void editAmountBill(String billCode, double amount);
    void editPriceBill(String billCode, double price);
}
