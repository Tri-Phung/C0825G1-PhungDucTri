package test_final.controller;

import test_final.common.exception.PhoneDuplicatedException;
import test_final.entity.Contacts;
import test_final.service.ContactService;
import test_final.service.IContactService;

import java.util.List;

public class ContactController {
    IContactService contactService = new ContactService();
    public List<Contacts> display(){
        return contactService.display();
    }
    public void save(Contacts contacts){
        contactService.save(contacts);
    }
    public List<Contacts> readFile(){
        return contactService.readFile();
    }
    public void writeFile(List<Contacts> contacts, boolean isAppend){
        contactService.writeFile(contacts, isAppend);
    }
    public boolean checkDuplicatedPhone (String phone) throws PhoneDuplicatedException {
        return contactService.checkDuplicatePhone(phone);
    }
    public void update(String phone){
        contactService.update(phone);
    }
    public void delete(String phone) {
        contactService.delete(phone);
    }
    public List<Contacts> searchByPhone(String phone){
        return contactService.searchByPhone(phone);
    }
    public List<Contacts> searchByName(String name){
        return contactService.searchByName(name);
    }
}
