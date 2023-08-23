package com.csmaster.orderSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csmaster.orderSys.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
