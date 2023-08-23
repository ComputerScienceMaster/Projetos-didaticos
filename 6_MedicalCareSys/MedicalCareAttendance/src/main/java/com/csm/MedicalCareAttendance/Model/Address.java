package com.csm.MedicalCareAttendance.Model;


import com.csm.MedicalCareAttendance.DTO.AddressDTORequest;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="STATE")
    private String state;

    @Column(name="CITY")
    private String city;

    @Column(name="STREET")
    private String street;

    @Column(name="NUMBER")
    private Integer number;

    @Column(name="COMPLEMENT")
    private String complement;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address", orphanRemoval = true)
    private Patient patient;

    public static Address of(AddressDTORequest p){
        return Address.builder()
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
