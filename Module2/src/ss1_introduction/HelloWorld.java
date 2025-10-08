package ss1_introduction;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Your name:");
        String name = reader.nextLine();
        System.out.println("Hello " + name);
    }
}
