package com.csmaster.orderSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csmaster.orderSys.model.Order;

public interface OrdersRepository extends JpaRepository<Order, Integer> {

}
