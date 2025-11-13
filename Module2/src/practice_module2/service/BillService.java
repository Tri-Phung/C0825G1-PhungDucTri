package practice_module2.service;

import practice_module2.entity.Bill;
import practice_module2.repository.BillRepository;

import java.time.LocalDate;
import java.util.List;

public class BillService implements IBillService{
    private final BillRepository billRepository = new BillRepository();

    @Override
    public void add(Bill bill) {
        billRepository.addBill(bill);
    }

    @Override
    public List<Bill> displayInfo() {
        return billRepository.getBills();
    }

    @Override
    public void editBill(String billCode, String customerCode) {
        billRepository.editCustomerCode(billCode,customerCode);
    }

    @Override
    public void editBill(String billCode, LocalDate billDate) {
        billRepository.editBillDate(billCode,billDate);
    }

    @Override
    public void editAmountBill(String billCode, double amount) {
        billRepository.editAmountBill(billCode,amount);
    }

    @Override
    public void editPriceBill(String billCode, double price) {
        billRepository.editPriceBill(billCode,price);
    }


}
