package com.aelmrabti.productapi.dto;

import com.aelmrabti.productapi.entity.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String code;

    private String name;

    private String description;

    private String image;

    private String category;

    private Double price;

    private Double quantity;

    private String internalReference;

    private ProductStatus inventoryStatus;

    private Long shellId;

    private Double rating;
}
