package ss17_io_binary_file_serialization.bai_tap.controller;

import ss17_io_binary_file_serialization.bai_tap.common.exception.IdDuplicatedException;
import ss17_io_binary_file_serialization.bai_tap.entity.Product;
import ss17_io_binary_file_serialization.bai_tap.service.IProductService;
import ss17_io_binary_file_serialization.bai_tap.service.ProductService;

import java.util.List;

public class ProductManagementController {
    private IProductService iService = new ProductService();

    public List<Product> getAllProducts() {
        return iService.getAll();
    }

    public void addProduct(Product product) {
        iService.add(product);
    }

    public Product findProductById(int id) {
        return iService.findById(id);
    }
    public boolean IdCheckDuplicate(int id) throws IdDuplicatedException {
        return iService.checkDuplicateId(id);
    }
    public List<Product> findByName(String name) {
        return iService.searchByName(name);
    }
}
