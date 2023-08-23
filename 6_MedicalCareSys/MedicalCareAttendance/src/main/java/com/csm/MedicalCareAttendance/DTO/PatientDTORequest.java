package com.csm.MedicalCareAttendance.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
public class PatientDTORequest implements Serializable {
    private final UUID id;
    private final String name;
    private final String gender;
    private final String email;
    private final String phone;
    private final UUID address;


}