package test_final.view;

import test_final.controller.ContactController;
import test_final.entity.Contacts;

import java.util.List;
import java.util.Scanner;

public class MenuPhoneInfo {
    private static ContactController contactController = new ContactController();

    public static void contactInfo() {
        Scanner scanner = new Scanner(System.in);
        displayContact(contactController.display());
        System.out.println("Thêm mới (y/n)");
        String choice = scanner.nextLine();
        switch (choice) {
            case "y":
                contactController.save(MainMenu.createContacts());
                break;
            case "n":
                MainMenu.mainMenu();
            default:
                System.out.println("Invalid choice. Please try again");
                contactInfo();
                break;
        }
    }

    public static void displayContact(List<Contacts> contactsList) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(String.format("%-5s| %-20s| %-20s| %-20s| %-20s| %-20s|\n", "STT", "Số điện thoại", "Nhóm", "Họ tên", "Giới tính", "Địa chỉ"));
        sb.append("------------------------------------------------------------------------------------------------------------------------\n");
        for (Contacts contact : contactsList) {
            sb.append(String.format("%-5s| %-20s| %-20s| %-20s| %-20s| %-20s|\n",
                    count++,
                    contact.getPhone(),
                    contact.getGroup(),
                    contact.getName(),
                    contact.getGender(),
                    contact.getAddress()));
        }
        System.out.println(sb);
    }
}
