package practice_module2.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ClassificationCustomerManagement {
    private static String filePath = "src/practice_module2/data/kindOfCustomer.csv";

    private static List<ClassificationCustomer> readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<ClassificationCustomer> classificationCustomers = new LinkedList<>();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ClassificationCustomer classificationCustomer = new ClassificationCustomer(data[0], data[1]);
                classificationCustomers.add(classificationCustomer);
            }
            return classificationCustomers;
        } catch (IOException e) {
            System.out.println("File not found or wrong path or content error");
        }
        return null;
    }

    public static String getClassificationName(int inputNumber) {
        switch (inputNumber) {
            case 1:
                return readFile(filePath).get(0).getClassificationName();
            case 2:
                return readFile(filePath).get(1).getClassificationName();
            case 3:
                return readFile(filePath).get(2).getClassificationName();
            default:
                return null;
        }
    }

    public static void displayClassificationCustomer() {
        int count = 0;
        for (ClassificationCustomer classificationCustomer : readFile(filePath)) {
            count++;
            System.out.print(count + ". ");
            System.out.println(classificationCustomer);
        }
    }
}
