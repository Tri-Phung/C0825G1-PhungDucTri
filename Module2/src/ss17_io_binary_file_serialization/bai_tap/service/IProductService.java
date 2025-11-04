package ss17_io_binary_file_serialization.bai_tap.service;


import ss17_io_binary_file_serialization.bai_tap.common.exception.IdDuplicatedException;
import ss17_io_binary_file_serialization.bai_tap.entity.Product;

import java.util.List;

public interface IProductService extends IService<Product> {
    boolean checkDuplicateId(int id) throws IdDuplicatedException;
    List<Product> searchByName(String name);
}
