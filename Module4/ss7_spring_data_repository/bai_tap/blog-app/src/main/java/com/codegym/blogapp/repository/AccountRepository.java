package com.codegym.blogapp.repository;

import com.codegym.blogapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    @Query(value = "select a from accounts a where a.username = :username and a.isDeleted is false")
    Account findByUsernameAndIsDeletedFalse(@Param("username") String username);
}
