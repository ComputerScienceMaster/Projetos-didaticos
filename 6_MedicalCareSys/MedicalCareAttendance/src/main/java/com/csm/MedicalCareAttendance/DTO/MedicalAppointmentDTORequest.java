package com.csm.MedicalCareAttendance.DTO;

import com.csm.MedicalCareAttendance.Model.MedicalAppointment;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * A DTO for the {@link MedicalAppointment} entity
 */
@Data
public class MedicalAppointmentDTORequest implements Serializable {
    private final UUID id;
    private final String status;
    private final String location;
    private final LocalDate appointmentDate;
    private final LocalDate returnDate;
    private final UUID patient;
    private final UUID doctor;

}