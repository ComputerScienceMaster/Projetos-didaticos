package com.csm.MedicalCareSales.Repository;

import com.csm.MedicalCareSales.Model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
}