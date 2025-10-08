package ss1_introduction.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width: ");
        width = scanner.nextFloat();
        System.out.print("Enter height: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("Area: " + area);
    }
}
