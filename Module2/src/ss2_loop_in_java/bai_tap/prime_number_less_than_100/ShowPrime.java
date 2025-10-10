package ss2_loop_in_java.bai_tap.prime_number_less_than_100;

public class ShowPrime {
    public static void main(String[] args) {
        int num = 0;
        while (num < 100) {
            if (checkPrimeNumber(num)) {
                System.out.println(num);
            }
            num++;
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
