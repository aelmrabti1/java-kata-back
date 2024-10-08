package com.aelmrabti.productapi.mapper;


import com.aelmrabti.productapi.dto.PatchRequest;
import com.aelmrabti.productapi.dto.ProductRequest;
import com.aelmrabti.productapi.dto.ProductResponse;
import com.aelmrabti.productapi.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductRequest requestDto);

    ProductEntity toEntity(PatchRequest requestDto);

    ProductResponse toResponse(ProductEntity entity);
}
