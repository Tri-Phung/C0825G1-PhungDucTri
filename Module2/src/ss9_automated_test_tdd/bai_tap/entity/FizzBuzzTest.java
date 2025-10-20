package ss9_automated_test_tdd.bai_tap.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {
    @Test
    @DisplayName("Testing input greater than 0")
    void testFizzBuzzGreaterThan0() {
        int number = 0;
        String expected = "input must be greater than 0";
        String result = new FizzBuzz().fizzBuzz(number);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing input can devide 3")
    void testFizzBuzzCanDevide3() {
        int number = 3;
        String expected = "Fizz";
        String result = new FizzBuzz().fizzBuzz(number);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing input can devide 5")
    void testFizzBuzzCanDevide5() {
        int number = 5;
        String expected = "Buzz";
        String result = new FizzBuzz().fizzBuzz(number);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing input can devide 3 and 5")
    void testFizzBuzzCanDevide3and5() {
        int number = 15;
        String expected = "FizzBuzz";
        String result = new FizzBuzz().fizzBuzz(number);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing input not can devide 3 and 5")
    void testFizzBuzzNotCanDevide3and5() {
        int number = 11;
        String expected = "11";
        String result = new FizzBuzz().fizzBuzz(number);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Testing input by new FizzBuzzTranslate")
    void testFizzBuzzTranslate() {
        String input = "chin chin";
        int number = new FizzBuzzTranslate().translate(input);
        String expected = "Fizz";
        String result = new FizzBuzz().fizzBuzz(number);
        assertEquals(expected, result);
    }
}