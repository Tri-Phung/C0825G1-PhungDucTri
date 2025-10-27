package ss12_map_tree.bai_tap.controller;

import ss12_map_tree.bai_tap.entity.Product;
import ss12_map_tree.bai_tap.service.ProductService;
import ss12_map_tree.bai_tap.service.ProductServiceImpl;

import java.util.List;

public class ProductManagerController {
    private final ProductService productService;

    public ProductManagerController() {
        this.productService = new ProductServiceImpl();
    }

    public ProductManagerController(ProductService productService) {
        this.productService = productService;
    }

    public boolean addProduct(Product product) {
        return productService.add(product);
    }

    public boolean editProduct(int id, String newName, double newPrice) {
        return productService.update(id, newName, newPrice);
    }

    public boolean deleteProduct(int id) {
        return productService.delete(id);
    }

    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    public List<Product> findProductsByName(String name) {
        return productService.findByName(name);
    }

    public List<Product> sortProductsAscending() {
        return productService.sortByPriceAsc();
    }

    public List<Product> sortProductsDescending() {
        return productService.sortByPriceDesc();
    }

    public boolean existsById(int id) {
        return productService.existsById(id);
    }
}