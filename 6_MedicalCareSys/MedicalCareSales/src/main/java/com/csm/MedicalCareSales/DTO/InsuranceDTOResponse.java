package com.csm.MedicalCareSales.DTO;

import com.csm.MedicalCareSales.Model.Insurance;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
@Builder
public class InsuranceDTOResponse implements Serializable {
    private final UUID id;
    private final String coverage;
    private final Double monthValue;
    private final String status;

    public static InsuranceDTOResponse of(Insurance d){
        return InsuranceDTOResponse.builder()
                .id(d.getId())
                .coverage(d.getCoverage().toString())
                .monthValue(d.getMonthValue())
                .status(d.getStatus().toString())
                .build();
    }
}