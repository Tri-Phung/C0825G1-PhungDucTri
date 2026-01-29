package com.codegym.productmanagementspringboot.specification;

import com.codegym.productmanagementspringboot.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecification {
    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> name == null || name.isEmpty() ? null : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }
    public static Specification<Product> priceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return (root, query, cb) -> {
            if (minPrice == null && maxPrice == null) return null;
            if (minPrice == null) return cb.lessThanOrEqualTo(root.get("price"), maxPrice);
            if (maxPrice == null) return cb.greaterThanOrEqualTo(root.get("price"), minPrice);
            return cb.between(root.get("price"), minPrice, maxPrice);
        };
    }
}
