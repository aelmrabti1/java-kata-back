package com.aelmrabti.productapi.service.impl;

import com.aelmrabti.productapi.entity.ProductEntity;
import com.aelmrabti.productapi.infrastrecture.exception.PatchException;
import com.aelmrabti.productapi.infrastrecture.exception.ResourceNotFoundException;
import com.aelmrabti.productapi.jpa.ProductRepository;
import com.aelmrabti.productapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
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
        ProductEntity retrievedProduct = this.get(id);
        try {
            applyPatch(product, retrievedProduct);
        } catch (Exception e) {
            throw new PatchException("Failed to apply patch due to access issues", e.getCause());
        }
        return productRepository.save(retrievedProduct);
    }

    void applyPatch(ProductEntity source, ProductEntity target) throws IllegalAccessException {
        Class<?> clazz = ProductEntity.class;
        final Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            final Object fieldVal = field.get(source);
            if (Objects.nonNull(fieldVal)) {
                field.set(target, fieldVal);
            }

            field.setAccessible(false);
        }
    }

    @Override
    public ProductEntity create(ProductEntity product) {
        return productRepository.save(product);
    }


}
