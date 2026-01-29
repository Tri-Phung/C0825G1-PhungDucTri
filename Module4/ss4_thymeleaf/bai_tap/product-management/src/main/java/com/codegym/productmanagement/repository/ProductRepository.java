package com.codegym.productmanagement.repository;

import com.codegym.productmanagement.entity.Product;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private static final Map<Integer, Product> products = new HashMap<>();
    static {
        products.put(1, new Product(1, "Laptop", 1000000, 10, "Laptop 15 inch"));
        products.put(2, new Product(2, "Mouse", 500, 100, "Mouse Logitech"));
        products.put(3, new Product(3, "Keyboard", 200, 100, "Keyboard Logitech"));
        products.put(4, new Product(4, "Headphone", 100, 100, "Headphone Bose"));
        products.put(5, new Product(5, "Monitor", 150000, 100, "Monitor Samsung"));
        products.put(6, new Product(6, "Camera", 10000, 100, "Camera Canon"));
        products.put(7, new Product(7, "Speaker", 500, 100, "Speaker Sony"));
        products.put(8, new Product(8, "Charger", 100, 100, "Charger Apple"));
        products.put(9, new Product(9, "Case", 1000, 100, "Case Samsung"));
        products.put(10, new Product(10, "Backpack", 5000, 100, "Backpack Adidas"));
        products.put(11, new Product(11, "Headset", 1000, 100, "Headset Sennheiser"));
    }
    public List<Product> findAll() {
        return List.copyOf(products.values());
    }
    public Product findById(int id) {
        return products.get(id);
    }
    public void save(Product product) {
        product.setId(Collections.max(products.keySet()) +1);
        products.put(product.getId(), product);
    }
    public void delete(int id) {
        products.remove(id);
    }
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    public List<Product> findByName(String name) {
        return products.values().stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
