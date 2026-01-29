package com.codegym.appbookborrowing.controller;

import com.codegym.appbookborrowing.entity.Book;
import com.codegym.appbookborrowing.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/detail";
    }

    @PostMapping("/{id}/borrow")
    public String borrow(@PathVariable Long id, Model model) {
        String borrowCode = bookService.borrowBook(id);
        model.addAttribute("borrowCode", borrowCode);
        return "book/borrow-success";
    }

    @GetMapping("/return")
    public String showReturnForm() {
        return "book/return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String borrowCode) {
        bookService.returnBook(borrowCode);
        return "redirect:/books";
    }
}
