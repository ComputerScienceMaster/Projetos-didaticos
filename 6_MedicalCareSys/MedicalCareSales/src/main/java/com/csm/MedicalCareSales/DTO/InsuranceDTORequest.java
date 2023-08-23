package com.csm.MedicalCareSales.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
public class InsuranceDTORequest implements Serializable {
    private final UUID id;
    private final String coverage;
    private final Double monthValue;
    private final String status;
    private final UUID order;
}