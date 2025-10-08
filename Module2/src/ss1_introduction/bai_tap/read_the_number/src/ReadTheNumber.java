import java.util.Scanner;

public class ReadTheNumber {
    public static void main(String[] args) {
        int maxValue = 999;
        int minValue = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number you want to read: ");
        int number = sc.nextInt();

        if (number >= minValue && number <= maxValue) {
            System.out.println(readNumber(number));
        } else {
            System.out.println("Number is out of range");
        }
    }
    private static String readNumber(int number) {
        if (number < 10) {
            return oneDigit(number);
        } else if (number < 20) {
            return twoDigitsBelowTwenty(number);
        } else if (number < 100) {
            return twoDigitsAboveTwenty(number);
        } else {
            return threeDigits(number);
        }
    }
    private static String oneDigit(int number) {
        switch (number) {
            case 0: return "Zero";
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }
    private static String twoDigitsBelowTwenty(int number) {
        switch (number) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
        }
    }
    private static String twoDigitsAboveTwenty(int number) {
        int tens = number / 10;
        int ones = number % 10;
        String tensWord = "";

        switch (tens) {
            case 2: tensWord = "Twenty"; break;
            case 3: tensWord = "Thirty"; break;
            case 4: tensWord = "Forty"; break;
            case 5: tensWord = "Fifty"; break;
            case 6: tensWord = "Sixty"; break;
            case 7: tensWord = "Seventy"; break;
            case 8: tensWord = "Eighty"; break;
            case 9: tensWord = "Ninety"; break;
        }
        if (ones == 0) {
            return tensWord;
        } else {
            return tensWord + " " + readNumber(ones);
        }
    }
    private static String threeDigits(int number) {
        int hundreds = number / 100;
        int remainder = number % 100;
        String hundredsWord = "";

        switch (hundreds) {
            case 1: hundredsWord = "One hundred"; break;
            case 2: hundredsWord = "Two hundred"; break;
            case 3: hundredsWord = "Three hundred"; break;
            case 4: hundredsWord = "Four hundred"; break;
            case 5: hundredsWord = "Five hundred"; break;
            case 6: hundredsWord = "Six hundred"; break;
            case 7: hundredsWord = "Seven hundred"; break;
            case 8: hundredsWord = "Eight hundred"; break;
            case 9: hundredsWord = "Nine hundred"; break;
        }

        if (remainder == 0) {
            return hundredsWord;
        } else {
            return hundredsWord + " and " + readNumber(remainder);
        }
    }
}
