package com.csm.MedicalCareSales.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
public class SellerDTORequest implements Serializable {
    private final UUID id;
    private final String username;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;
}