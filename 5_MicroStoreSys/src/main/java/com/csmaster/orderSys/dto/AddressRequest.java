package com.csmaster.orderSys.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AddressRequest implements Serializable {

    private Integer id;
    private String street;
    private Integer stablishmentNumber;
    private String neighborhood;
    private String complement;
    private String zipCode;

}
