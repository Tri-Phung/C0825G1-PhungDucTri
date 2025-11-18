package test_final.service;

import test_final.common.exception.PhoneDuplicatedException;
import test_final.entity.Contacts;
import test_final.repository.ContactRepository;

import java.util.List;

public class ContactService implements IContactService{
    ContactRepository contactRepository = new ContactRepository();

    @Override
    public void save(Contacts contacts) {
        contactRepository.add(contacts);
    }

    @Override
    public void delete(String phone) {
        contactRepository.delete(phone);
    }

    @Override
    public void update(String phone) {
        contactRepository.update(phone);
    }

    @Override
    public List<Contacts> display() {
        return contactRepository.display();
    }

    @Override
    public List<Contacts> readFile() {
        return contactRepository.readFile();
    }

    @Override
    public void writeFile(List<Contacts> contacts, boolean isAppend) {
        contactRepository.writeFile(contacts, isAppend);
    }

    @Override
    public boolean checkDuplicatePhone(String phone) throws PhoneDuplicatedException {
        List<Contacts> contactsList = contactRepository.display();
        for (Contacts contact : contactsList) {
            if (contact.getPhone().equals(phone)) {
                throw new PhoneDuplicatedException("Phone is duplicated. Please try another one");
            }
        }
        return false;
    }

    @Override
    public List<Contacts> searchByPhone(String phone) {
        return contactRepository.searchByPhone(phone);
    }

    @Override
    public List<Contacts> searchByName(String name) {
        return contactRepository.searchByName(name);
    }
}
