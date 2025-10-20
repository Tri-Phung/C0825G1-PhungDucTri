package ss9_automated_test_tdd.bai_tap.entity;

public class FizzBuzzTranslate {
    public int translate(String string) {
        String[] input = string.split(" ");
        String result = "";
        switch (input[0]) {
            case "mot":
                result += "1";
                break;
            case "hai":
                result += "2";
                break;
            case "ba":
                result += "3";
                break;
            case "bon":
                result += "4";
                break;
            case "nam":
                result += "5";
                break;
            case "sau":
                result += "6";
                break;
            case "bay":
                result += "7";
                break;
            case "tam":
                result += "8";
                break;
            case "chin":
                result += "9";
                break;
        }
        switch (input[1]) {
            case "mot":
                result += "1";
                break;
            case "hai":
                result += "2";
                break;
            case "ba":
                result += "3";
                break;
            case "bon":
                result += "4";
                break;
            case "nam":
                result += "5";
                break;
            case "sau":
                result += "6";
                break;
            case "bay":
                result += "7";
                break;
            case "tam":
                result += "8";
                break;
            case "chin":
                result += "9";
                break;
        }
        return Integer.parseInt(result);
    }
}
