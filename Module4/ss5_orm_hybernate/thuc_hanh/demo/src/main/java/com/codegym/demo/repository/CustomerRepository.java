package com.codegym.demo.repository;

import com.codegym.demo.entity.Customer;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    public List<Customer> findAll(){
        List<Customer> customers = BaseRepository.entityManager.createQuery("select c from customers c", Customer.class).getResultList();
        return customers;
    }
    public void save(Customer customer){
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try{
            if(!transaction.isActive()){
                transaction.begin();
            }
            if(customer.getId() == 0){
                BaseRepository.entityManager.persist(customer);
            }
            else{
                BaseRepository.entityManager.merge(customer);
            }
            transaction.commit();
        } catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
    public Customer findById(int id){
        return BaseRepository.entityManager.createQuery("select c from customers c where c.id = :id", Customer.class).setParameter("id", id).getSingleResult();
    }

    public void remove(int id){
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try{
            if(!transaction.isActive()){
                transaction.begin();
            }
            Customer customer = findById(id);
            BaseRepository.entityManager.remove(customer);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
}
