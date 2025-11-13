package practice_module2.service;

import practice_module2.common.exception.CustomerCodeDuplicatedException;
import practice_module2.entity.Customer;

import java.util.List;

public interface ICustomerService<T> extends IService<T>{
    List<T> findCustomerByName(String name);
    boolean checkDuplicateCustomerCode(String customerCode) throws CustomerCodeDuplicatedException;
}
