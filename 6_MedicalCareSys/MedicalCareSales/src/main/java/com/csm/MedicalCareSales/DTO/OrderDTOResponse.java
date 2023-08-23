package com.csm.MedicalCareSales.DTO;

import com.csm.MedicalCareSales.Model.Order;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;


@Data
@Builder
public class OrderDTOResponse implements Serializable {
    private final UUID id;
    private final UUID patient;
    private final SellerDTOResponse seller;
    private final LocalDate saleDate;

    public static OrderDTOResponse of(Order d){
        return OrderDTOResponse.builder()
                .id(d.getId())
                .saleDate(d.getSaleDate())
                .patient(d.getPatient())
                .seller(SellerDTOResponse.of(d.getSeller()))
                .build();
    }
}