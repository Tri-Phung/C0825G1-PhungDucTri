package test_final.view;

import test_final.common.exception.PhoneDuplicatedException;
import test_final.common.validate.Validate;
import test_final.controller.ContactController;
import test_final.entity.Contacts;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainMenu {
    private static ContactController contactController = new ContactController();

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        int choice;
        while (true) {
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            choice = Validate.inputInteger("chức năng");
            switch (choice) {
                case 1:
                    MenuPhoneInfo.contactInfo();
                    break;
                case 2:
                    contactController.save(createContacts());
                    break;
                case 3:
                    System.out.println("Nhập vào số điện thoại cần sửa:");
                    String phone = sc.nextLine();
                    contactController.update(phone);
                    break;
                case 4:
                    System.out.println("Nhập vào số điện thoại cần xóa:");
                    phone = sc.nextLine();
                    contactController.delete(phone);
                    break;
                case 5:
                    System.out.println("Bạn muốn tìm theo tên hay số điện thoại?");
                    System.out.println("1. Tên");
                    System.out.println("2. SDT");
                    choice = Validate.inputInteger("lựa chọn tương ứng");
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập vào tên:");
                            String name = sc.nextLine();
                            MenuPhoneInfo.displayContact(contactController.searchByName(name));
                            break;
                        case 2:
                            System.out.println("Nhập vào sdt:");
                            String sdt = sc.nextLine();
                            MenuPhoneInfo.displayContact(contactController.searchByPhone(sdt));
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again");
                            break;
                    }
                    break;
                case 6:
                    MenuPhoneInfo.displayContact(contactController.readFile());
                    break;
                case 7:
                    contactController.writeFile(contactController.display(),true);
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    public static Contacts createContacts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số điện thoại");
        String phone;
        while (true) {
            try {
                phone = sc.nextLine();
                contactController.checkDuplicatedPhone(phone);
                break;
            } catch (PhoneDuplicatedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập vào nhóm");
        String group = sc.nextLine();
        System.out.println("Nhập vào họ tên");
        String name = sc.nextLine();
        System.out.println("Nhập vào giới tính");
        String gender = sc.nextLine();
        System.out.println("Nhập vào địa chỉ");
        String address = sc.nextLine();
        System.out.println("Nhập vào ngày sinh (dd/mm/yyyy):");
        String dob = sc.nextLine();
        System.out.println("Nhập vào email:");
        String email = sc.nextLine();
        return new Contacts(phone, group, name, gender, address, dob, email);
    }
}
