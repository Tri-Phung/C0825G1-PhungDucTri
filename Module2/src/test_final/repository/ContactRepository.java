package test_final.repository;

import test_final.entity.Contacts;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ContactRepository {
    private static String filePath = "src/test_final/data/contacts.csv";
    private static List<Contacts> contactsList = new LinkedList<>();
    public List<Contacts> display() {
        return contactsList;
    }
    public List<Contacts> readFile() {
        List<Contacts> contacts = new LinkedList<>();
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            String[] data;
            while ((line = br.readLine()) != null) {
                data = line.split(",");
                contacts.add(new Contacts(data[0],data[1],data[2],data[3],data[4],data[5],data[6]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Read file error");
        }
        return contacts;
    }
    public void writeFile(List<Contacts> contacts, boolean isAppend) {
        File file = new File(filePath);
        try (FileWriter fileWriter = new FileWriter(file, isAppend);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Contacts contact : contacts) {
                bufferedWriter.write(convertContactsToString(contact));
                bufferedWriter.newLine();
            }
            System.out.println("Write successfully");
        } catch (IOException e) {
            System.out.println("Write file error");
        }
    }
    public void add(Contacts contacts) {
        contactsList.add(contacts);
        System.out.println("Thêm mục danh bạ thành công!");
    }
    public void delete(String phone) {
        boolean isFound = false;
        for (Contacts contact : contactsList) {
            if (contact.getPhone().equals(phone)) {
                isFound = true;
                break;
            }
        }
        if (isFound){
            System.out.println("Bạn có chắc muốn xóa liên lạc này chứ? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "y":
                    break;
                case "n":
                    return;
                default:
                    System.out.println("invalid choice");
                    return;
            }
            contactsList.removeIf(contact -> contact.getPhone().equals(phone));
            writeFile(contactsList, false);
            System.out.println("Xóa thành công");
        }
        else System.out.println("Không tìm được danh bạ với số điện thoại trên.");
    }
    public void update(String phone) {
        boolean isFound = false;
        for (Contacts contact : contactsList) {
            if (contact.getPhone().equals(phone)) {
                isFound = true;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Nhập vào nhóm mới:");
                String group = scanner.nextLine();
                contact.setGroup(group);
                System.out.println("Nhập vào Họ tên mới:");
                String name = scanner.nextLine();
                contact.setName(name);
                System.out.println("Nhập vào giới tính mới:");
                String gender = scanner.nextLine();
                contact.setGender(gender);
                System.out.println("Nhập vào địa chỉ mới:");
                String address = scanner.nextLine();
                contact.setAddress(address);
                System.out.println("Nhập vào ngày sinh mới (dd/mm/yyyy):");
                String dob = scanner.nextLine();
                contact.setDob(dob);
                System.out.println("Nhập vào email mới:");
                String email = scanner.nextLine();
                contact.setEmail(email);
                break;
            }
        }
        if (isFound){
            writeFile(contactsList, false);
            System.out.println("Cập nhật số điện thoại thành công");
        }
        else System.out.println("Không tìm được danh bạ với số điện thoại trên.");
    }
    private static String convertContactsToString(Contacts contacts) {
        return contacts.getPhone()+","+contacts.getGroup()+","+contacts.getName()+","+contacts.getGender()+","+contacts.getAddress()+","+contacts.getDob()+","+contacts.getEmail();
    }

    public List<Contacts> searchByPhone(String phone) {
        return contactsList.stream().filter(contact -> contact.getPhone().equals(phone)).toList();
    }
    public List<Contacts> searchByName(String name) {
        return contactsList.stream().filter(contact -> contact.getName().toLowerCase().contains(name.toLowerCase())).toList();
    }
}
