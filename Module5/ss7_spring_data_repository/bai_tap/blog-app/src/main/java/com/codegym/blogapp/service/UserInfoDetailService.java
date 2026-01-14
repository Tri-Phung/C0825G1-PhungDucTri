package com.codegym.blogapp.service;

import com.codegym.blogapp.dto.UserInfoUserDetails;
import com.codegym.blogapp.entity.Account;
import com.codegym.blogapp.repository.AccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetailService implements UserDetailsService {
    AccountRepository accountRepository;
    public UserInfoDetailService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsernameAndIsDeletedFalse(username);
        if(account == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        UserInfoUserDetails userDetails = new UserInfoUserDetails(account);
        return userDetails;
    }
}
