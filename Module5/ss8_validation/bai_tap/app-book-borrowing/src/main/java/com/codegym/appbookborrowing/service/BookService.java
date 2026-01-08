package com.codegym.appbookborrowing.service;

import com.codegym.appbookborrowing.entity.Book;
import com.codegym.appbookborrowing.entity.BorrowRecord;
import com.codegym.appbookborrowing.exception.InvalidBorrowCodeException;
import com.codegym.appbookborrowing.exception.OutOfStockException;
import com.codegym.appbookborrowing.repository.BookRepository;
import com.codegym.appbookborrowing.repository.BorrowRecordRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService{
    BookRepository bookRepository;
    BorrowRecordRepository borrowRecordRepository;

    public BookService(BookRepository bookRepository, BorrowRecordRepository borrowRecordRepository) {
        this.bookRepository = bookRepository;
        this.borrowRecordRepository = borrowRecordRepository;
    }

    @Override
    @Transactional
    public String borrowBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new NoResultException("Book not found"));
        if(book.getQuantity() <= 0) throw new OutOfStockException("Book is out of stock");
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
        String borrowCode = generateBorrowCode();
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setBorrowCode(borrowCode);
        borrowRecord.setBook(book);
        borrowRecord.setBorrowDate(java.time.LocalDateTime.now());
        borrowRecord.setReturned(false);
        borrowRecordRepository.save(borrowRecord);
        return borrowCode;
    }

    private String generateBorrowCode() {
        Random random = new Random();
        int code = 10000+ random.nextInt(90000);
        return String.valueOf(code);
    }

    @Override
    @Transactional
    public void returnBook(String borrowCode) {
        BorrowRecord borrowRecord = borrowRecordRepository.findByBorrowCodeAndReturnedIsFalse(borrowCode).orElseThrow(() -> new InvalidBorrowCodeException("Borrow code not found or returned"));
        borrowRecord.setReturned(true);
        borrowRecordRepository.save(borrowRecord);
        Book book = borrowRecord.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoResultException("Book not found"));
    }

    @Override
    public Book save(Book entity) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
