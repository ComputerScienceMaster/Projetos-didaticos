package com.csmaster.orderSys.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductRequest implements Serializable {

    private Integer id;
    private String productName;
    private Double productValue;

}
