package com.aelmrabti.productapi.web.controller;

import com.aelmrabti.productapi.dto.PatchRequest;
import com.aelmrabti.productapi.dto.ProductRequest;
import com.aelmrabti.productapi.dto.ProductResponse;
import com.aelmrabti.productapi.entity.ProductEntity;
import com.aelmrabti.productapi.mapper.ProductMapper;
import com.aelmrabti.productapi.service.ProductService;
import com.aelmrabti.productapi.web.api.ProductApi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponse> getAll(Integer page, Integer size) {
        return productService.getAll(page, size).map(productMapper::toResponse);
    }

    @Override
    public ProductResponse get(Long id) {
        return productMapper.toResponse(productService.get(id));
    }

    @Override
    public void delete(Long id) {
        productService.delete(id);
    }

    @Override
    public ProductResponse partialUpdate(Long id, PatchRequest request) {
        ProductEntity product = productMapper.toEntity(request);
        return productMapper.toResponse(productService.partialUpdate(id, product));
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        final ProductEntity entityToSave = productMapper.toEntity(request);
        return productMapper.toResponse(productService.create(entityToSave));
    }
}
