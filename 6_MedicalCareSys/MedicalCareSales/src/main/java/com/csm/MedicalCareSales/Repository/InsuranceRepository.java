package com.csm.MedicalCareSales.Repository;

import com.csm.MedicalCareSales.Model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {
}