package ss15_exception_handle_and_debug.thuc_hanh;

import java.util.Scanner;

public class CalculationExample {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hãy nhập x: ");
        int x = sc.nextInt();
        System.out.println("Hãy nhập y: ");
        int y = sc.nextInt();
        CalculationExample calc = new CalculationExample();
        calc.calculate(x,y);
    }

    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tổng x + y = " + a);
            System.out.println("Hiệu x - y = " + b);
            System.out.println("Tích x * y = " + c);
            System.out.println("Thương x / y = " + d);
            } catch (ArithmeticException e) {
            System.out.println("Xảy ra ngoại lệ: " + e.getMessage());
        }
    }
}
