package com.codegym.appbookborrowing.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity(name = "borrow_records")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "borrow_code", unique = true, length = 5)
    private String borrowCode;
    @Column(name = "borrow_date")
    private LocalDateTime borrowDate;
    private boolean returned;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
