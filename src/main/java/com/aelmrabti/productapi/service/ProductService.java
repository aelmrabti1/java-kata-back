package com.aelmrabti.productapi.service;

import com.aelmrabti.productapi.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface ProductService {
    ProductEntity get(Long id);

    Page<ProductEntity> getAll(Integer page, Integer size);

    void delete(Long id);

    ProductEntity partialUpdate(Long id, ProductEntity product);

    ProductEntity create(ProductEntity product);
}
