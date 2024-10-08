package com.aelmrabti.productapi.dto;

import com.aelmrabti.productapi.entity.ProductStatus;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(name = "id", description = "product id", example = "1")
    private Long id;

    @Schema(name = "code", description = "product code", example = "AZ1234")
    private String code;

    @Schema(name = "name", description = "product name", example = "MacBook Pro M3")
    private String name;

    @Schema(name = "description", example = "MacBook Pro 14 Pouces (Puce M3)")
    private String description;

    @Schema(name = "image", description = "product image url")
    private String image;

    @Schema(name = "category")
    private String category;

    @Schema(name = "price", description = "product price", example = "30000")
    private Double price;

    @Schema(name = "quantity", description = "product quantity")
    private Double quantity;

    @Schema(name = "internalReference", description = "N0001")
    private String internalReference;

    @Schema(name = "inventoryStatus")
    ProductStatus inventoryStatus;

    @Schema(name = "shellId")
    private Long shellId;

    @Schema(name = "rating")
    private Double rating;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
