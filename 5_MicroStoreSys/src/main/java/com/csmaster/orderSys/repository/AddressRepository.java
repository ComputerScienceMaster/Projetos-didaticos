package com.csmaster.orderSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.csmaster.orderSys.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
