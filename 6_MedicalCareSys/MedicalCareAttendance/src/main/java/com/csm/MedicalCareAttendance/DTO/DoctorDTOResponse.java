package com.csm.MedicalCareAttendance.DTO;

import com.csm.MedicalCareAttendance.Model.Doctor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
@Builder
public class DoctorDTOResponse implements Serializable {
    private final UUID id;
    private final String name;
    private final String gender;
    private final String email;
    private final String phone;
    private final String medicalSpecialty;
    private final Boolean isSurgeon;

    public static DoctorDTOResponse of(Doctor d){
        return DoctorDTOResponse.builder()
                .id(d.getId())
                .name(d.getName())
                .email(d.getEmail())
                .gender(d.getGender())
                .phone(d.getPhone())
                .medicalSpecialty(d.getMedicalSpecialty())
                .isSurgeon(d.getIsSurgeon())
                .build();
    }


}