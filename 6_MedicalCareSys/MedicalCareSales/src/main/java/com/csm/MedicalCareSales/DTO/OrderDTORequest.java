package com.csm.MedicalCareSales.DTO;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


@Data
public class OrderDTORequest implements Serializable {
    private UUID id;
    private final LocalDate saleDate;
    private final UUID patient;
    private final UUID seller;
    private final UUID insurance;
    private final String channel;

}