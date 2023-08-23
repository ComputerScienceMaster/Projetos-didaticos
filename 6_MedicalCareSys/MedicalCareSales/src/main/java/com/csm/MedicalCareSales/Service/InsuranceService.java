package com.csm.MedicalCareSales.Service;

import com.csm.MedicalCareSales.DTO.InsuranceDTORequest;
import com.csm.MedicalCareSales.Model.Insurance;
import com.csm.MedicalCareSales.Model.Order;
import com.csm.MedicalCareSales.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsuranceService {

    @Autowired
    private OrderRepository orderRepository;


    public void relateOrderToInsurance(InsuranceDTORequest insuranceResponse, Insurance insurance) {
        Optional<Order> order = orderRepository.findById(insuranceResponse.getOrder());
        order.ifPresent(o -> {
            o.setInsurance(insurance);
            orderRepository.save(o);
        });
    }
}
