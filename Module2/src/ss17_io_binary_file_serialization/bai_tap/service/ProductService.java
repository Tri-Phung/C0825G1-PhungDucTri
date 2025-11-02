package ss17_io_binary_file_serialization.bai_tap.service;


import ss17_io_binary_file_serialization.bai_tap.common.exception.IdDuplicatedException;
import ss17_io_binary_file_serialization.bai_tap.entity.Product;
import ss17_io_binary_file_serialization.bai_tap.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> getAll() {
        return productRepository.getListOfProducts();
    }

    @Override
    public void add(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean checkDuplicateId(int id) throws IdDuplicatedException {
        List<Product> products = getAll();
        for (Product product : products) {
            if (product.getId() == id) {
                throw new IdDuplicatedException("Id trùng lặp");
            }
        }
        return false;
    }
}
