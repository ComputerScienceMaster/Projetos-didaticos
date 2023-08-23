package com.csm.MedicalCareAttendance.Model;

import com.csm.MedicalCareAttendance.DTO.PatientDTORequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="PATIENT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="NAME")
    private String name;

    @Column(name="GENDER")
    private String gender;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PHONE")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "FK_ADDRESS", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_PATIENT_ADDRESS"))
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    List<MedicalAppointment> medicalAppointments;

    public static Patient of(PatientDTORequest patient, Address address){
        return Patient.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .gender(patient.getGender())
                .address(address)
                .build();
    }


}
