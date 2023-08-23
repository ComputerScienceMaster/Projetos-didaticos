package com.csmaster.orderSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.csmaster.orderSys.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
