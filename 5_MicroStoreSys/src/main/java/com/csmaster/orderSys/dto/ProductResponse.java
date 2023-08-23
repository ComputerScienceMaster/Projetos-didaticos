package com.csmaster.orderSys.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.csmaster.orderSys.model.Client;
import com.csmaster.orderSys.model.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {

    private Integer id;
    private String name;
    private Double value;
    
    public static List<ProductResponse> of(List<Product> products) {
        return Objects.nonNull(products)
                ? products.stream().map(ProductResponse::of).collect(Collectors.toList())
                : null;
    }

    public static ProductResponse of(Product product) {
        return ProductResponse.builder().id(product.getIdProduct())
                .name(product.getProductName())
                .value(product.getProductValue())
                .build();
    }

}
