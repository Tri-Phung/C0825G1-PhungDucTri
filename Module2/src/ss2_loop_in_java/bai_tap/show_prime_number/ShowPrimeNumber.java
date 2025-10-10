package ss2_loop_in_java.bai_tap.show_prime_number;

public class ShowPrimeNumber {
    public static void main(String[] args) {
        int count = 0;
        int number = 0;
        while (count < 20) {
            if (checkPrimeNumber(number)) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }
    private static boolean checkPrimeNumber(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number%i == 0) return false;
        }
        return true;
    }
}
