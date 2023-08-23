package com.csm.MedicalCareAttendance.Model;

import com.csm.MedicalCareAttendance.DTO.ExaminationDTORequest;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="EXAMINATION")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Examination {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name="NAME")
    private String name;

    @Column(name="EXAM_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate examDate;

    @Column(name="TECHNICIAN")
    private String technician;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "FK_EXAMINATION", referencedColumnName = "ID",
            foreignKey = @ForeignKey(name = "FK_EXAMINATION"))
    private MedicalAppointment medicalAppointment;


    public static Examination of(ExaminationDTORequest d) {
        return Examination.builder()
                .id(d.getId())
                .name(d.getName())
                .examDate(d.getExamDate())
                .technician(d.getTechnician())
                .medicalAppointment(MedicalAppointment
                        .builder()
                        .id(d.getMedicalAppointmentId()).build())
                .build();
    }
}
