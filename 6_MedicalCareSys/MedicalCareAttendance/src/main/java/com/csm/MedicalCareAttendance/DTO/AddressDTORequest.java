package com.csm.MedicalCareAttendance.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
@Builder
public class AddressDTORequest implements Serializable {
    private final UUID id;
    private final String country;
    private final String state;
    private final String city;
    private final String street;
    private final Integer number;
    private final String complement;
}