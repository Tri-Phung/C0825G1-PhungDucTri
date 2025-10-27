package ss12_map_tree.bai_tap.service;

import ss12_map_tree.bai_tap.entity.Product;

import java.util.List;

public interface ProductService {
    boolean add(Product product);
    boolean update(int id, String newName, double newPrice);
    boolean delete(int id);
    List<Product> getAll();
    List<Product> findByName(String name);
    List<Product> sortByPriceAsc();
    List<Product> sortByPriceDesc();
    boolean existsById(int id);
}