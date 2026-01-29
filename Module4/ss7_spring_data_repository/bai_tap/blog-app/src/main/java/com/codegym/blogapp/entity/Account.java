package com.codegym.blogapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "accounts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends Parent{
    @Id
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private AppRole appRole;
}
