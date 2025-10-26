package ss12_map_tree.bai_tap.controller;

import ss12_map_tree.bai_tap.entity.ProductManager;

import java.util.Scanner;

public class ProductTest {
    static void main() {
        ProductManager pm = new ProductManager();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                System.out.println("--- PRODUCT MANAGER MENU ---");
                System.out.println("1. Add a new product");
                System.out.println("2. Edit product by ID");
                System.out.println("3. Delete product by ID");
                System.out.println("4. Display all products");
                System.out.println("5. Search product by name");
                System.out.println("6. Sort products ascending by price");
                System.out.println("7. Sort products descending by price");
                System.out.println("0. Exit program");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        pm.addProduct();
                        break;
                    case 2:
                        System.out.print("Enter product ID to edit: ");
                        int editId = Integer.parseInt(sc.nextLine());
                        pm.editProduct(editId);
                        break;
                    case 3:
                        System.out.print("Enter product ID to delete: ");
                        int deleteId = Integer.parseInt(sc.nextLine());
                        pm.deleteProduct(deleteId);
                        break;
                    case 4:
                        pm.displayProducts();
                        break;
                    case 5:
                        System.out.print("Enter product name to search: ");
                        String findName = sc.nextLine();
                        pm.findProductByName(findName);
                        break;
                    case 6:
                        pm.sortProductsAscending();
                        break;
                    case 7:
                        pm.sortProductsDescending();
                        break;
                    case 0:
                        System.out.println("Program terminated.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (choice != 0);

        sc.close();
    }
}
