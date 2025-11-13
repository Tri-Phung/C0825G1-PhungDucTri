package practice_module2.view;

import practice_module2.common.exception.CustomerCodeDuplicatedException;
import practice_module2.common.validate.Validate;
import practice_module2.controller.BillController;
import practice_module2.controller.CustomerController;
import practice_module2.entity.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static final CustomerController customerController = new CustomerController();
    private static final BillController billController = new BillController();

    public static void menuCustomer() {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1. Add customer");
            System.out.println("2. Display all customers");
            System.out.println("3. Find customer by name");
            System.out.println("4. Add new bill");
            System.out.println("5. Edit bill");
            System.out.println("6. Display bill detail");
            System.out.println("7. Exit");
            choice = Validate.inputInteger("your choice");
            switch (choice) {
                case 1:
                    while (true) {
                        int type = getTypeOfCustomer();
                        if (type == 1) {
                            System.out.println("Enter customer code: ");
                            String customerCode;
                            while (true){
                                try {
                                    customerCode = sc.nextLine();
                                    customerController.checkDuplicatedCustomerCode(customerCode);
                                    break;
                                } catch (CustomerCodeDuplicatedException e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                            if (!customerCode.contains("KHVN")) {
                                System.out.println("Vietnamese customer code must have string 'KHVN'");
                                continue;
                            }
                            System.out.println("Enter customer name: ");
                            String customerName = sc.nextLine();
                            System.out.println("Classification of Vietnamese customer list:");
                            ClassificationCustomerManagement.displayClassificationCustomer();
                            System.out.println("Enter the classification: ");
                            int classification = Validate.inputInteger("classification");
                            String kindOfCustomer = ClassificationCustomerManagement.getClassificationName(classification);
                            if (kindOfCustomer == null) {
                                System.out.println("Invalid classification");
                                continue;
                            }
                            double comsumptionStandard = Validate.inputDouble("consumption standard");
                            VietnameseCustomer vietnameseCustomer = new VietnameseCustomer(customerCode, customerName, kindOfCustomer, comsumptionStandard);
                            customerController.addCustomer(vietnameseCustomer);
                            break;
                        } else if (type == 2) {
                            System.out.println("Enter customer code: ");
                            String customerCode = sc.nextLine();
                            if (!customerCode.contains("KHNN")) {
                                System.out.println("Foreign customer code must have string 'KHNN'");
                                continue;
                            }
                            System.out.println("Enter customer name: ");
                            String customerName = sc.nextLine();
                            System.out.println("Enter the nationality: ");
                            String nationality = sc.nextLine();
                            Customer foreignCustomer = new ForeignCustomer(customerCode, customerName, nationality);
                            customerController.addCustomer(foreignCustomer);
                            break;
                        } else {
                            System.out.println("Invalid choice");
                        }
                    }
                    break;
                case 2:
                    displayCustomer(customerController.displayInfo());
                    break;
                case 3:
                    System.out.println("Enter customer name: ");
                    String findName = sc.nextLine();
                    List<Customer> result = customerController.findCustomerByName(findName);
                    if (result.isEmpty()) {
                        System.out.println("Customer not found");
                        break;
                    }
                    displayCustomer(result);
                    break;
                case 4:
                    System.out.println("==Customer list==");
                    displayCustomer(customerController.displayInfo());
                    System.out.println("Enter customer code: ");
                    String customerCode = sc.nextLine();
                    boolean found = false;
                    for (Customer customer : customerController.displayInfo()) {
                        if (customer.getCustomerCode().equals(customerCode)) {
                            found = true;
                            LocalDate billDate = Validate.inputDate("bill date");
                            double amount = Validate.inputDouble("amount");
                            double price = Validate.inputDouble("price");
                            Bill bill = new Bill(customerCode, billDate, amount, price);
                            bill.calculateTotal(customer);
                            billController.addBill(bill);
                        }
                    }
                    if (!found) {
                        System.out.println("Customer not found");
                        break;
                    }
                    break;
                case 5:
                    System.out.println("==Bill list==");
                    List<Bill> bills = billController.displayInfo();
                    displayBill(bills);
                    Bill selectedBill = getBillNumber(bills);
                    System.out.println("What you wanna change:");
                    System.out.println("1. Customer code");
                    System.out.println("2. Bill date");
                    System.out.println("3. Amount");
                    System.out.println("4. Price");
                    int choiceChange = Validate.inputInteger("choice change");
                    switch (choiceChange) {
                        case 1:
                            System.out.println("Enter new customer code: ");
                            String newCustomerCode = sc.nextLine();
                            billController.editBillCustomerCode(selectedBill.getBillCode(), newCustomerCode);
                            break;
                        case 2:
                            billController.editBillDate(selectedBill.getBillCode(), Validate.inputDate("new bill date").toString());
                            break;
                        case 3:
                            billController.editBillAmount(selectedBill.getBillCode(), Validate.inputDouble("new amount"));
                            break;
                        case 4:
                            billController.editBillPrice(selectedBill.getBillCode(), Validate.inputDouble("new price"));
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                case 6:
                    displayBill(billController.displayInfo());
                    System.out.println("Check the bill detail or type 0 to exit");
                    selectedBill = getBillNumber(billController.displayInfo());
                    if (selectedBill == null) break;
                    Customer selectedCustomer = null;
                    for (Customer customer : customerController.displayInfo()) {
                        if (customer.getCustomerCode().equals(selectedBill.getCustomerCode())) {
                            selectedCustomer = customer;
                            break;
                        }
                    }
                    if (selectedCustomer == null ) {
                        System.out.println("Customer not found");
                    }
                    else displayBillDetail(selectedBill, selectedCustomer);
                    break;
                case 7:
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println("Invalid choice");
                    return;
            }
        }
    }

    private static Bill getBillNumber(List<Bill> bills) {
        int billNumber = Validate.inputInteger("bill number");
        if (billNumber == 0) return null;
        if (billNumber > bills.size() || billNumber < 0) {
            System.out.println("Invalid bill number, please enter again");
            return getBillNumber(bills);
        }
        Bill selectedBill = bills.get(billNumber - 1);
        return selectedBill;
    }

    private static int getTypeOfCustomer() {
        System.out.println("1. Vietnamese customer");
        System.out.println("2. Foreign customer");
        switch (Validate.inputInteger("type of customer")) {
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    public static void displayCustomer(List<Customer> customers) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s| %-20s| %-20s| %-20s| %-20s|\n", "Customer Code", "Customer Name", "Kind of Customer", "Comsumption Standard", "Nationality"));
        sb.append("-------------------------------------------------------------------------------------------------------------\n");
        for (Customer customer : customers) {
            if (customer instanceof VietnameseCustomer) {
                VietnameseCustomer vietnameseCustomer = (VietnameseCustomer) customer;
                sb.append(String.format("%-20s| %-20s| %-20s| %-20s| %-20s|\n",
                        vietnameseCustomer.getCustomerCode(),
                        vietnameseCustomer.getCustomerName(),
                        vietnameseCustomer.getKindOfCustomer(),
                        vietnameseCustomer.getComsumptionStandard(),
                        ""));
            } else {
                ForeignCustomer foreignCustomer = (ForeignCustomer) customer;
                sb.append(String.format("%-20s| %-20s| %-20s| %-20s| %-20s|\n",
                        foreignCustomer.getCustomerCode(),
                        foreignCustomer.getCustomerName(),
                        "",
                        "",
                        foreignCustomer.getNationality()));
            }
        }
        System.out.println(sb);
    }

    public static void displayBill(List<Bill> bills) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(String.format("%-5s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s|\n", "STT", "Bill Code", "Customer Code", "Bill Date", "Amount", "Price", "Total"));
        sb.append("------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (Bill bill : bills) {
            sb.append(String.format("%-5s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s|\n",
                    count,
                    bill.getBillCode(),
                    bill.getCustomerCode(),
                    bill.getBillDate(),
                    bill.getAmount(),
                    bill.getPrice(),
                    bill.getTotal()));
            count++;
        }
        System.out.println(sb);
    }

    public static void displayBillDetail(Bill bill, Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s| %-20s| %-20s| %-20s| %-20s| %-20s|\n", "Bill Code", "Customer Name", "Bill Date", "Amount", "Price", "Total"));
        sb.append("------------------------------------------------------------------------------------------------------------------------------------------\n");
        sb.append(String.format("%-20s| %-20s| %-20s| %-20s| %-20s| %-20s|\n",
                bill.getBillCode(),
                customer.getCustomerName(),
                bill.getBillDate(),
                bill.getAmount(),
                bill.getPrice(),
                bill.getTotal()));
        System.out.println(sb);
    }
}
