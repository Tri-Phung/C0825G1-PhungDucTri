package practice_module2.repository;

import practice_module2.entity.Customer;
import practice_module2.entity.ForeignCustomer;
import practice_module2.entity.VietnameseCustomer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepository<T> {
    static String filePath = "D:/codegym/C0825G1-PhungDucTri/Module2/src/practice_module2/data/customer.csv";
    public List<Customer> findAllCustomer() {
        return readCustomerFromFile();
    }
    public void addCustomer(Customer customer) {
        List<Customer> customers = new LinkedList<>();
        customers.add(customer);
        writeCustomerToFile(customers, true);
        System.out.println("Add customer successfully");
    }
    static List<Customer> readCustomerFromFile() {
        List<Customer> customers = new LinkedList<>();
        File file = new File(filePath);
        try(FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr)) {
            String line;
            String[] data;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                String customerCode = data[0];
                String customerName = data[1];
                if (customerCode.contains("KHVN")) {
                    String kindOfCustomer = data[2];
                    double comsumptionStandard = Double.parseDouble(data[3]);
                    customers.add(new VietnameseCustomer(customerCode, customerName, kindOfCustomer, comsumptionStandard));
                } else if (customerCode.contains("KHNN")) {
                    String nationality = data[2];
                    customers.add(new ForeignCustomer(customerCode, customerName, nationality));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Read file error");;
        }
        return customers;
    }
    static void writeCustomerToFile(List<Customer> customers, boolean append) {
        File file = new File(filePath);
        try (FileWriter fw = new FileWriter(file, append);
        BufferedWriter bw = new BufferedWriter(fw)) {
            for (Customer customer : customers) {
                if (customer.getCustomerCode().contains("KHVN")){
                    bw.write(convertVietNamCustomerToString((VietnameseCustomer) customer));
                    bw.newLine();
                }
                else if (customer.getCustomerCode().contains("KHNN")){
                    bw.write(convertForeignCustomerToString((ForeignCustomer) customer));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Write file error");
        }
    }

    private static String convertForeignCustomerToString(ForeignCustomer customer) {
        return customer.getCustomerCode() + "," + customer.getCustomerName() + "," + customer.getNationality();
    }

    private static String convertVietNamCustomerToString(VietnameseCustomer customer) {
        return customer.getCustomerCode() + "," + customer.getCustomerName() + "," + customer.getKindOfCustomer() + "," + customer.getComsumptionStandard();
    }

    public List<Customer> findCustomerByName(String name) {
        return readCustomerFromFile().stream()
                .filter(p -> p.getCustomerName().toLowerCase().contains(name.toLowerCase())).toList();
    }
}
