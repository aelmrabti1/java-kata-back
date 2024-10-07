package com.aelmrabti.productapi.dto;

import com.aelmrabti.productapi.entity.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long id;

    private String code;

    private String name;

    private String description;

    private String image;

    private String category;

    private Double price;

    private Double quantity;

    private String internalReference;

    ProductStatus inventoryStatus;

    private Long shellId;

    private Double rating;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
