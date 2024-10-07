package com.aelmrabti.productapi.jpa;

import com.aelmrabti.productapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
