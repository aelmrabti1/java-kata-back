package com.aelmrabti.productapi.mapper;


import com.aelmrabti.productapi.dto.ProductRequest;
import com.aelmrabti.productapi.dto.ProductResponse;
import com.aelmrabti.productapi.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(ProductRequest requestDto);

    ProductResponse toResponse(ProductEntity entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ProductEntity doUpdate(ProductEntity source, @MappingTarget ProductEntity target);
}
