package test_final.service;

import test_final.common.exception.PhoneDuplicatedException;
import test_final.entity.Contacts;

import java.util.List;

public interface IContactService {
    void save(Contacts contacts);
    void delete(String phone);
    void update(String phone);
    List<Contacts> display();
    List<Contacts> readFile();
    void writeFile(List<Contacts> contacts, boolean isAppend);
    boolean checkDuplicatePhone(String phone) throws PhoneDuplicatedException;
    List<Contacts> searchByPhone(String phone);
    List<Contacts> searchByName(String name);
}
