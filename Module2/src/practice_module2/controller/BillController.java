package practice_module2.controller;

import practice_module2.entity.Bill;
import practice_module2.service.BillService;
import practice_module2.service.IBillService;

import java.util.List;

public class BillController {
    IBillService billService = new BillService();
    public void editBillCustomerCode(String billCode, String customerCode){
        billService.editBill(billCode, customerCode);
    }
    public void editBillDate(String billCode, String date){
        billService.editBill(billCode, date);
    }
    public void editBillAmount(String billCode, double amount){
        billService.editAmountBill(billCode, amount);
    }
    public void editBillPrice(String billCode, double price){
        billService.editPriceBill(billCode, price);
    }
    public void addBill(Bill bill){
        billService.add(bill);
    }
    public List<Bill> displayInfo(){
        return billService.displayInfo();
    }
}
