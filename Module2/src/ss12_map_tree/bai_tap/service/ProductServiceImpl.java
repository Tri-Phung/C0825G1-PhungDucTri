package ss12_map_tree.bai_tap.service;

import ss12_map_tree.bai_tap.entity.Product;
import ss12_map_tree.bai_tap.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository = new ProductRepository();

    @Override
    public boolean add(Product product) {
        if (product == null) return false;
        if (existsById(product.getId())) return false;
        return productRepository.add(product);
    }

    @Override
    public boolean update(int id, String newName, double newPrice) {
        Product existing = productRepository.getProductById(id);
        if (existing == null) return false;
        return productRepository.update(id, newName, newPrice);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productRepository.getAllProducts());
    }

    @Override
    public List<Product> findByName(String name) {
        if (name == null) name = "";
        return productRepository.findProductsByName(name);
    }

    @Override
    public List<Product> sortByPriceAsc() {
        return productRepository.sortProductsAscending();
    }

    @Override
    public List<Product> sortByPriceDesc() {
        return productRepository.sortProductsDescending();
    }

    @Override
    public boolean existsById(int id) {
        return productRepository.existsById(id);
    }
}