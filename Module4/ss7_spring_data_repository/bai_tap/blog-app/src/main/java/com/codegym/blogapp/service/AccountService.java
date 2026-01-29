package com.codegym.blogapp.service;

import com.codegym.blogapp.entity.Account;
import com.codegym.blogapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public Account save(Account entity) {
        return accountRepository.save(entity);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
