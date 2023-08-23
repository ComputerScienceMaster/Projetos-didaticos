package com.csm.MedicalCareAttendance.DTO;

import com.csm.MedicalCareAttendance.Model.Address;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
@Builder
public class AddressDTOResponse implements Serializable {
    private final UUID id;
    private final String country;
    private final String state;
    private final String city;
    private final String street;
    private final Integer number;
    private final String complement;

    public static AddressDTOResponse of(Address p){
        return AddressDTOResponse.builder()
                .id(p.getId())
                .city(p.getCity())
                .country(p.getCountry())
                .complement(p.getComplement())
                .number(p.getNumber())
                .state(p.getState())
                .street(p.getStreet())
                .build();
    }
}