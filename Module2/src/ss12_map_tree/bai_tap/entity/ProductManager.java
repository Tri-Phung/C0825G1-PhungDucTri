package ss12_map_tree.bai_tap.entity;

import ss12_map_tree.bai_tap.service.ProductDescendingPriceComparator;

import java.util.*;

public class ProductManager {
    private List<Product> productList;
    private Scanner scanner;

    public ProductManager() {
        this.productList = new LinkedList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addProduct() {
        int id;
        String name;
        double price;
        while (true) {
            try {
                System.out.println("Enter product ID: ");
                id = Integer.parseInt(scanner.nextLine());
                if (checkExistedID(id)) {
                    System.out.println("ID is already used.Please enter another ID");
                    continue;
                }
                System.out.println("Enter product name: ");
                name = scanner.nextLine();
                System.out.println("Enter product price: ");
                price = Double.parseDouble(scanner.nextLine());
                productList.add(new Product(id, name, price));
                System.out.println("Product added successfully");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private boolean checkExistedID(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void editProduct(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                while (true) {
                    try {
                        System.out.println("Enter new name:");
                        product.setName(scanner.nextLine());
                        System.out.println("Enter new price:");
                        product.setPrice(Double.parseDouble(scanner.nextLine()));
                        System.out.println("Product edited successfully");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                    }
                }
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void deleteProduct(int id) {
        if (productList.isEmpty()) {
            System.out.println("Product list is empty");
            return;
        } else if (!checkExistedID(id)) {
            System.out.println("Product not found");
            return;
        }
        productList.removeIf(product -> product.getId() == id);
        System.out.println("Product deleted successfully");
    }

    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Product list is empty");
            return;
        }
        System.out.println("Product list:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void findProductByName(String name) {
        ArrayList<Product> foundProduct = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProduct.add(product);
            }
        }
        if (foundProduct.isEmpty()) {
            System.out.println("Product not found");
            return;
        }
        System.out.println("Search result:");
        for (Product product : foundProduct) {
            System.out.println(product);
        }
    }

    public void sortProductsAscending() {
        Collections.sort(productList);
        System.out.println("Product list sorted ascending");
        displayProducts();
    }

    public void sortProductsDescending() {
        productList.sort(new ProductDescendingPriceComparator());
        System.out.println("Product list sorted descending");
        displayProducts();
    }
}
