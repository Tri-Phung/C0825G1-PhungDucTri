package com.codegym.phone_management.service;

import com.codegym.phone_management.entity.Smartphone;
import com.codegym.phone_management.repository.SmartphoneRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneService implements IService{
    private final SmartphoneRepository repository;
    public SmartphoneService(SmartphoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Smartphone> findAll() {
        return repository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoResultException("Smartphone not found"));
    }

    @Override
    public Smartphone save(Smartphone entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        if(findById(id)!=null) repository.deleteById(id);
    }
}
