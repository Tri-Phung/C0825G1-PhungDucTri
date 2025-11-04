package ss19_string_regex.bai_tap;

import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private static final String PHONE_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
    public ValidatePhoneNumber() {
    }
    public static boolean validate(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        return pattern.matcher(phoneNumber).matches();
    }

    static void main() {
        ValidatePhoneNumber phoneNumberExample = new ValidatePhoneNumber();
        String[] validPhoneNumber = new String[]{"(84)-(0978489648)","(84)-(0128489648)","(84)-(0128680040)"};
        String[] invalidPhoneNumber = new String[]{"(a8)-(22222222)", "(84)-(22b22222)", "(84)-(9978489648)"};
        for (String phoneNumber : validPhoneNumber) {
            boolean isvalid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number is " + phoneNumber + " is valid: " + isvalid);
        }
        for (String phoneNumber : invalidPhoneNumber) {
            boolean isvalid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number is " + phoneNumber + " is valid: " + isvalid);
        }
    }
}
