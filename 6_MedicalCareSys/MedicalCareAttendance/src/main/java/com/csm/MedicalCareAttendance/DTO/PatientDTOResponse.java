package com.csm.MedicalCareAttendance.DTO;

import com.csm.MedicalCareAttendance.Model.Patient;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class PatientDTOResponse implements Serializable {
    private final UUID id;
    private final String name;
    private final String gender;
    private final String email;
    private final String phone;
    private final AddressDTOResponse address;

    public static PatientDTOResponse of(Patient p){
        return PatientDTOResponse.builder()
                .id(p.getId())
                .name(p.getName())
                .email(p.getEmail())
                .gender(p.getGender())
                .phone(p.getPhone())
                .address(AddressDTOResponse.of(p.getAddress()))
                .build();
    }
}