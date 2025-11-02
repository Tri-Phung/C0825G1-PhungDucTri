package ss17_io_binary_file_serialization.bai_tap.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    void add(T t);
    void update(int id, T t);
    void delete(int id);
    T findById(int id);
}
