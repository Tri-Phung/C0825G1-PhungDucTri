package com.codegym.cartmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private Long productId;
    private String productName;
    private String productCode;
    private Double price;
    private Integer quantity;
    private String imageUrl;

    public Double getSubTotal() {
        return price * quantity;
    }
}