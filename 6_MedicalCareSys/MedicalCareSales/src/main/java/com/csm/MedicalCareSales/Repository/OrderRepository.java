package com.csm.MedicalCareSales.Repository;

import com.csm.MedicalCareSales.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}