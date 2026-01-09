package com.codegym.cartmanagement.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Cart{
    private Map<Long, CartItem> items = new HashMap<>();

    public void addItem(Product product) {
        Long productId = product.getId();
        if (items.containsKey(productId)) {
            CartItem item = items.get(productId);
            item.setQuantity(item.getQuantity() + 1);
        } else {
            CartItem newItem = new CartItem(
                    product.getId(),
                    product.getName(),
                    product.getCode(),
                    product.getPrice(),
                    1,
                    product.getImageUrl()
            );
            items.put(productId, newItem);
        }
    }

    public void updateQuantity(Long productId, Integer quantity) {
        if (items.containsKey(productId)) {
            if (quantity <= 0) {
                items.remove(productId);
            } else {
                items.get(productId).setQuantity(quantity);
            }
        }
    }

    public void removeItem(Long productId) {
        items.remove(productId);
    }

    public Double getTotalPrice() {
        return items.values().stream()
                .mapToDouble(CartItem::getSubTotal)
                .sum();
    }

    public Integer getTotalItems() {
        return items.values().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    public void clear() {
        items.clear();
    }
}