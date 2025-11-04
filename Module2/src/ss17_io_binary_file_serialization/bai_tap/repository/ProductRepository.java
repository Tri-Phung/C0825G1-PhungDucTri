package ss17_io_binary_file_serialization.bai_tap.repository;

import ss17_io_binary_file_serialization.bai_tap.entity.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    public List<Product> getListOfProducts() {
        return readFile();
    }

    private static List<Product> readFile() {
        List<Product> products = new ArrayList<>();
        File file = new File("src/ss17_io_binary_file_serialization/bai_tap/data/product.dat");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            products = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Read file error");
        }
        return products;
    }

    private static void writeFile(List<Product> products) {
        File file = new File("src/ss17_io_binary_file_serialization/bai_tap/data/product.dat");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(products);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Write file error");
        }
    }

    public void addProduct(Product product) {
        List<Product> productToAdd = getListOfProducts();
        productToAdd.add(product);
        writeFile(productToAdd);
    }

}
