package practice_module2.common.validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validate {
    public static int inputInteger(String mess) {
        Scanner scanner = new Scanner(System.in);
        int temp;
        while (true) {
            try {
                System.out.print("Nhập "+mess+": ");
                temp = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(mess+" phải là số nguyên. Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định. Vui lòng nhập lại");
            }
        }
        return temp;
    }
    public static  double inputDouble(String mess) {
        Scanner scanner = new Scanner(System.in);
        double temp;
        while (true) {
            try {
                System.out.print("Nhập "+mess+": ");
                temp = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(mess+" phải là số. Vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi không xác định. Vui lòng nhập lại");
            }
        }
        return temp;
    }
    public static LocalDate inputDate(String mess) {
        Scanner scanner = new Scanner(System.in);
        LocalDate temp;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // định dạng ngày/tháng/năm

        while (true) {
            try {
                System.out.print("Nhập " + mess + " (dd/MM/yyyy): ");
                String input = scanner.nextLine().trim();
                temp = LocalDate.parse(input, formatter);
                break; // hợp lệ -> thoát vòng lặp
            } catch (DateTimeParseException e) {
                System.out.println("Sai định dạng! Vui lòng nhập theo dạng ngày/tháng/năm (vd: 25/10/2025).");
            } catch (Exception e) {
                System.out.println("⚠️ Lỗi không xác định. Vui lòng nhập lại.");
            }
        }
        return temp;
    }
}
