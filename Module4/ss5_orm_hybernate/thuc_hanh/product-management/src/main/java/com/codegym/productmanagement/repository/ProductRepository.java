package com.codegym.productmanagement.repository;

import com.codegym.productmanagement.entity.Product;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepository {
    public List<Product> findAll() {
        return BaseRepository.entityManager.createQuery("select p from products p",Product.class).getResultList();
    }
    public Product findById(int id) {
        return BaseRepository.entityManager.createQuery("select p from products p where p.id = :id",Product.class).setParameter("id",id).getSingleResult();
    }
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try{
            if(!transaction.isActive()){
                transaction.begin();
            }
            BaseRepository.entityManager.persist(product);
            transaction.commit();
        } catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
    public void delete(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try{
            if(!transaction.isActive()){
                transaction.begin();
            }
            Product product = findById(id);
            BaseRepository.entityManager.remove(product);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
    public void update(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        try{
            if(!transaction.isActive()){
                transaction.begin();
            }
            BaseRepository.entityManager.merge(product);
            transaction.commit();
        } catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }

    public List<Product> search(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        StringBuilder hql = new StringBuilder("select p from products p where 1=1");
        if(name != null && !name.isEmpty()){
            hql.append(" and lower(p.name) like '%").append(name.toLowerCase()).append("%'");
        }
        if(minPrice != null){
            hql.append(" and p.price >= ").append(minPrice);
        }
        if(maxPrice != null){
            hql.append(" and p.price <= ").append(maxPrice);
        }
        return BaseRepository.entityManager.createQuery(hql.toString(),Product.class).getResultList();
    }
}
