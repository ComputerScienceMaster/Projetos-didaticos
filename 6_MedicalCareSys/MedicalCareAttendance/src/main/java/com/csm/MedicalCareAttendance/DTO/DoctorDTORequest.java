package com.csm.MedicalCareAttendance.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;


@Data
public class DoctorDTORequest implements Serializable {
    private final UUID id;
    private final String name;
    private final String gender;
    private final String email;
    private final String phone;
    private final String medicalSpecialty;
    private final Boolean isSurgeon;

}