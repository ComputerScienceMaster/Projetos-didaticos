package com.csm.MedicalCareAttendance.Repository;

import com.csm.MedicalCareAttendance.Model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination, UUID> {
}