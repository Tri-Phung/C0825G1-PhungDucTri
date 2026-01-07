package com.codegym.validateformregister.service;

import com.codegym.validateformregister.entity.User;
import com.codegym.validateformregister.repository.UserRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoResultException("User not found"));
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
