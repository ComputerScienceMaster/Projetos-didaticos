package com.csm.MedicalCareAttendance.Repository;

import com.csm.MedicalCareAttendance.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}