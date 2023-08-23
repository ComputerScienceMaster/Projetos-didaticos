package com.csm.MedicalCareAttendance.Model;

import com.csm.MedicalCareAttendance.DTO.MedicalAppointmentDTORequest;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="MEDICALAPPOINTMENT")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAppointment
{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="STATUS")
    private String status;

    @Column(name="LOCATION")
    private String location;

    @Column(name="APPOINTMENT_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;

    @Column(name="RETURN_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_PATIENT", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_PATIENT_MEDICAL_APPOINTMENT"))
    private Patient patient;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_DOCTOR", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_DOCTOR_MEDICAL_APPOINTMENT"))
    private Doctor doctor;

    @OneToMany(mappedBy = "medicalAppointment", cascade = CascadeType.ALL)
    private List<Examination> examinations;

    public static MedicalAppointment of(MedicalAppointmentDTORequest d){
        return MedicalAppointment.builder()
                .id(d.getId())
                .status(d.getStatus())
                .location(d.getLocation())
                .appointmentDate(d.getAppointmentDate())
                .returnDate(d.getReturnDate())
                .patient(Patient.builder().id(d.getPatient()).build())
                .doctor(Doctor.builder().id(d.getDoctor()).build())
                .build();
    }


}
