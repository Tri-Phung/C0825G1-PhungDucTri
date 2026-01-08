package com.codegym.appbookborrowing.repository;

import com.codegym.appbookborrowing.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    Optional<BorrowRecord> findByBorrowCodeAndReturnedIsFalse(String borrowCode);
}
