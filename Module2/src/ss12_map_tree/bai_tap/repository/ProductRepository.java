package ss12_map_tree.bai_tap.repository;

import ss12_map_tree.bai_tap.entity.Product;

import java.util.LinkedList;
import java.util.List;

public class ProductRepository {
    private static List<Product> productList = new LinkedList<>();

    static {
        productList.add(new Product(1, "Laptop", 1000000));
        productList.add(new Product(2, "Phone", 500000));
        productList.add(new Product(3, "Watch", 200000));
        productList.add(new Product(4, "Shoes", 100000));
        productList.add(new Product(5, "Shirt", 50000));
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean update(int id, String newName, double newPrice) {
        Product product = getProductById(id);
        if (product == null) return false;
        product.setName(newName);
        return false;
    }

    public boolean delete(int id) {
        return productList.removeIf(p -> p.getId() == id);
    }

    public boolean add(Product product) {
        return productList.add(product);
    }

    public boolean existsById(int id) {
        return productList.stream()
                .anyMatch(p -> p.getId() == id);
    }

    public List<Product> findProductsByName(String name) {
        return productList.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<Product> sortProductsAscending() {
        List<Product> copy = new LinkedList<>(productList);
        copy.sort(null);
        return copy;
    }

    public List<Product> sortProductsDescending() {
        List<Product> copy = new LinkedList<>(productList);
        copy.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        return copy;
    }
}
