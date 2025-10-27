package ss12_map_tree.bai_tap.view;

import ss12_map_tree.bai_tap.controller.ProductManagerController;
import ss12_map_tree.bai_tap.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductManagerMainMenu {
    public static void mainMenu() {
        ProductManagerController controller = new ProductManagerController();
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
                    case 1: {
                        try {
                            System.out.print("Enter product ID: ");
                            int id = Integer.parseInt(sc.nextLine());
                            if (controller.existsById(id)) {
                                System.out.println("ID is already used. Please enter another ID.");
                                break;
                            }
                            System.out.print("Enter product name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter product price: ");
                            double price = Double.parseDouble(sc.nextLine());
                            boolean ok = controller.addProduct(new Product(id, name, price));
                            System.out.println(ok ? "Product added successfully" : "Failed to add product");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                        break;
                    }
                    case 2: {
                        try {
                            System.out.print("Enter product ID to edit: ");
                            int editId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter new name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new price: ");
                            double newPrice = Double.parseDouble(sc.nextLine());
                            boolean ok = controller.editProduct(editId, newName, newPrice);
                            System.out.println(ok ? "Product edited successfully" : "Product not found");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                        break;
                    }
                    case 3: {
                        try {
                            System.out.print("Enter product ID to delete: ");
                            int deleteId = Integer.parseInt(sc.nextLine());
                            boolean ok = controller.deleteProduct(deleteId);
                            System.out.println(ok ? "Product deleted successfully" : "Product not found");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                        break;
                    }
                    case 4: {
                        List<Product> all = controller.getAllProducts();
                        if (all.isEmpty()) {
                            System.out.println("Product list is empty");
                        } else {
                            System.out.println("Product list:");
                            all.forEach(System.out::println);
                        }
                        break;
                    }
                    case 5: {
                        System.out.print("Enter product name to search: ");
                        String findName = sc.nextLine();
                        List<Product> found = controller.findProductsByName(findName);
                        if (found.isEmpty()) {
                            System.out.println("Product not found");
                        } else {
                            System.out.println("Search result:");
                            found.forEach(System.out::println);
                        }
                        break;
                    }
                    case 6: {
                        List<Product> asc = controller.sortProductsAscending();
                        System.out.println("Product list sorted ascending");
                        if (asc.isEmpty()) {
                            System.out.println("Product list is empty");
                        } else {
                            asc.forEach(System.out::println);
                        }
                        break;
                    }
                    case 7: {
                        List<Product> desc = controller.sortProductsDescending();
                        System.out.println("Product list sorted descending");
                        if (desc.isEmpty()) {
                            System.out.println("Product list is empty");
                        } else {
                            desc.forEach(System.out::println);
                        }
                        break;
                    }
                    case 0:
                        System.out.println("Program terminated.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (choice != 0);
    }
}
