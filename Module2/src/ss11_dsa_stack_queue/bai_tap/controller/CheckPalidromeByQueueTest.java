package ss11_dsa_stack_queue.bai_tap.controller;

import ss11_dsa_stack_queue.bai_tap.entity.CheckPalidromeByQueue;

public class CheckPalidromeByQueueTest {
    static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        System.out.println("Is '" + str + "' a palindrome? \n" + CheckPalidromeByQueue.isPalindrome(str));
    }
}
