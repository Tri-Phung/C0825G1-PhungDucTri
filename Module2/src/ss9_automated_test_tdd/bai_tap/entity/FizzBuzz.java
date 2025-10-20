package ss9_automated_test_tdd.bai_tap.entity;

public class FizzBuzz {
    public FizzBuzz() {
    }
    public String fizzBuzz(int number) {
        if (number <= 0){
            return "input must be greater than 0";
        }
        else if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        }
        else if (number % 3 == 0) {
            return "Fizz";
        }
        else if (number % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }
}
