package com.csm.MedicalCareSales.DTO;

import com.csm.MedicalCareSales.Model.Seller;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
@Builder
public class SellerDTOResponse implements Serializable {
    private final UUID id;
    private final String username;
    private final String password;
    private final String name;
    private final String email;
    private final String phone;

    public static SellerDTOResponse of(Seller d){
        return SellerDTOResponse.builder()
                .id(d.getId())
                .username(d.getUsername())
                .password(d.getPassword())
                .name(d.getName())
                .email(d.getEmail())
                .phone(d.getPhone())
                .build();
    }
}