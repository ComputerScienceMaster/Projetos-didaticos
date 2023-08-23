package com.csm.MedicalCareSales.Messaging.service;

import com.csm.MedicalCareSales.DTO.OrderDTORequest;
import com.csm.MedicalCareSales.Messaging.QueueConfigurationParameters;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class OrderMessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(UUID id, OrderDTORequest order) {
        order.setId(id);
        rabbitTemplate.convertAndSend(QueueConfigurationParameters.ORDERS, order);
    }
}