package com.csm.MedicalCareAttendance.Model;

import com.csm.MedicalCareAttendance.DTO.DoctorDTORequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="DOCTOR")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

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

    @Column(name="MEDICAL")
    private String medicalSpecialty;

    @Column(name="ISSURGEON")
    private Boolean isSurgeon;




    @JsonIgnore
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<MedicalAppointment> medicalAppointments;

    public static Doctor of(DoctorDTORequest d) {
       return Doctor.builder()
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
