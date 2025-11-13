package practice_module2.repository;

import practice_module2.entity.Bill;
import practice_module2.entity.VietnameseCustomer;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class BillRepository {
    private static String filePath = "D:/codegym/C0825G1-PhungDucTri/Module2/src/practice_module2/data/bill.csv";
    private static List<Bill> readBillFromFile() {
        List<Bill> bills = new LinkedList<>();
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String[] data;
            while ((line = br.readLine())!= null) {
                data = line.split(",");
                String billCode = data[0];
                String customerCode = data[1];
                LocalDate billDate = LocalDate.parse(data[2]);
                double amount = Double.parseDouble(data[3]);
                double price = Double.parseDouble(data[4]);
                double total = Double.parseDouble(data[5]);
                Bill bill = new Bill(customerCode, billDate, amount, price);
                bill.setTotal(total);
                bill.setBillCode(billCode);
                bills.add(bill);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Read file error");;
        }
        return bills;
    }
    private static void writeBillToFile(List<Bill> bills, boolean append) {
        File file = new File(filePath);
        try (FileWriter fw = new FileWriter(file, append);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Bill bill : bills) {
                if (bill.getCustomerCode().contains("KHVN")){
                    bw.write(bill.getBillCode()+ "," +bill.getCustomerCode() + "," + bill.getBillDate() + "," + bill.getAmount() + "," + bill.getPrice()+","+bill.getTotal());
                    bw.newLine();
                }
                else if (bill.getCustomerCode().contains("KHNN")){
                    bw.write(bill.getBillCode()+ "," +bill.getCustomerCode() + "," + bill.getBillDate() + "," + bill.getAmount() + "," + bill.getPrice()+","+bill.getTotal());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Write file error");
        }
    }
    public void addBill(Bill bill) {
        List<Bill> bills = new LinkedList<>();
        bills.add(bill);
        writeBillToFile(bills, true);
        System.out.println("Add bill successfully");
    }
    public List<Bill> getBills() {
        return readBillFromFile();
    }

    public void editCustomerCode(String billCode, String customerCode) {
        List<Bill> bills = readBillFromFile();
        for (Bill b : bills) {
            if (b.getBillCode().equals(billCode)) {
                b.setCustomerCode(customerCode);
            }
        }
        writeBillToFile(bills, false);
        System.out.println("Edit customer code successfully");
    }
    public void editBillDate(String billCode, LocalDate billDate) {
        List<Bill> bills = readBillFromFile();
        for (Bill b : bills) {
            if (b.getBillCode().equals(billCode)) {
                b.setBillDate(billDate);
            }
        }
        writeBillToFile(bills, false);
        System.out.println("Edit bill date successfully");
    }
    public void editAmountBill(String billCode, double amount) {
        List<Bill> bills = readBillFromFile();
        for (Bill b : bills) {
            if (b.getBillCode().equals(billCode)) {
                b.setAmount(amount);
            }
        }
        writeBillToFile(bills, false);
        System.out.println("Edit amount successfully");
    }
    public void editPriceBill(String billCode, double price) {
        List<Bill> bills = readBillFromFile();
        for (Bill b : bills) {
            if (b.getBillCode().equals(billCode)) {
                b.setPrice(price);
            }
        }
        writeBillToFile(bills, false);
        System.out.println("Edit price successfully");
    }
}
