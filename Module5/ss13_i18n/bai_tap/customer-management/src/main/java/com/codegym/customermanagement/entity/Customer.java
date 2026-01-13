package com.codegym.customermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name is required")
    @Column(name = "name",nullable = false)
    private String name;
    @NotBlank(message = "Email is required")
    @Column(name = "email",nullable = false)
    private String email;
    @NotBlank(message = "Phone is required")
    @Column(name = "phone",nullable = false)
    private String phone;
    @Column(name = "address")
    private String address;
}
