package com.csm.MedicalCareFinances.Billing;


import com.MedicalCareSysLib.DTO.OrderDTORequest;
import com.csm.MedicalCareFinances.Messaging.QueueConfigurationParameters;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    @RabbitListener(queues = QueueConfigurationParameters.ORDERS)
    private void createInsuranceByOrder(OrderDTORequest order) {
        System.out.println(order);
    }

}
