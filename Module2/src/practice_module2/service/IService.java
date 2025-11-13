package practice_module2.service;

import java.util.List;

public interface IService<T> {
    void add(T something);
    List<T> displayInfo();
}
