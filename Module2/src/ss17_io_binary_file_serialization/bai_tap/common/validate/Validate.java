package ss17_io_binary_file_serialization.bai_tap.common.validate;

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
}
