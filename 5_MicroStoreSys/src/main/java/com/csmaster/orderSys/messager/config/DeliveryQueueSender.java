package com.csmaster.orderSys.messager.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csmaster.orderSys.dto.OrderRequest;

@Component
public class DeliveryQueueSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(OrderRequest order) {
        System.out.println("Mensagem enviada!");
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
    }
}
