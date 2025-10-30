package ss16_io_text_file.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readFileText(String filePath) {
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            System.out.println("Sum: " + sum);
        } catch (FileNotFoundException e) {
            System.out.println("File not found or wrong path");
        } catch (IOException e) {
            System.out.println("Content error");;
        }
    }

    static void main() {
        System.out.println("Enter file path: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        ReadFileExample example = new ReadFileExample();
        example.readFileText(path);
    }
}
