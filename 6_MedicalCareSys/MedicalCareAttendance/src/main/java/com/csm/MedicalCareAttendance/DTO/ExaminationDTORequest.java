package com.csm.MedicalCareAttendance.DTO;

import com.csm.MedicalCareAttendance.Model.Examination;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * A DTO for the {@link Examination} entity
 */
@Data
public class ExaminationDTORequest implements Serializable {
    private final UUID id;
    private final String name;
    private final LocalDate examDate;
    private final String technician;
    private final UUID medicalAppointmentId;

}