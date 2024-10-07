package com.aelmrabti.productapi.service.impl;

import com.aelmrabti.productapi.entity.ProductEntity;
import com.aelmrabti.productapi.infrastrecture.exception.ResourceNotFoundException;
import com.aelmrabti.productapi.jpa.ProductRepository;
import com.aelmrabti.productapi.mapper.ProductMapper;
import com.aelmrabti.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_SIZE = 100;

    @Override
    public ProductEntity get(Long id) {
        final Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new ResourceNotFoundException(ProductEntity.class, id);
        }

        return product.get();
    }

    @Override
    public Page<ProductEntity> getAll(Integer page, Integer size) {
        page = Optional.ofNullable(page).orElse(DEFAULT_PAGE);
        size = Optional.ofNullable(size).orElse(DEFAULT_SIZE);
        return productRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public void delete(Long id) {
        final ProductEntity product = this.get(id);
        productRepository.delete(product);
    }

    @Override
    public ProductEntity partialUpdate(Long id, ProductEntity product) {
        final ProductEntity retrievedProduct = this.get(id);
        final ProductEntity updatedProduct = productMapper.doUpdate(product, retrievedProduct);
        return productRepository.save(updatedProduct);
    }

    @Override
    public ProductEntity create(ProductEntity product) {
        return productRepository.save(product);
    }


}
