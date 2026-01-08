package com.codegym.appbookborrowing.service;

import com.codegym.appbookborrowing.entity.Book;

public interface IBookService extends IService<Book>{
    String borrowBook(Long bookId);
    void returnBook(String borrowCode);
}
