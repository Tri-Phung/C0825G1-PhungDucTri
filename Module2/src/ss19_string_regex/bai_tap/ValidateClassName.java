package ss19_string_regex.bai_tap;

import java.util.regex.Pattern;

public class ValidateClassName {
    private static final String REGEX = "^[CAP][0-9]{4}[GHIK]$";
    public ValidateClassName() {
    }
    public static boolean validate(String className) {
        Pattern pattern = Pattern.compile(REGEX);
        return pattern.matcher(className).matches();
    }

    static void main() {
        ValidateClassName classNameExample = new ValidateClassName();
        String[] validClassName = new String[]{"C0223G", "A0323K"};
        String[] invalidClassName = new String[]{"M0318G", "P0323A"};
        for (String className : validClassName) {
            boolean isvalid = classNameExample.validate(className);
            System.out.println("Class name is " + className + " is valid: " + isvalid);
        }
        for (String className : invalidClassName) {
            boolean isvalid = classNameExample.validate(className);
            System.out.println("Class name is " + className + " is valid: " + isvalid);
        }
    }
}
