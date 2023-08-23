package com.csmaster.orderSys.messager.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.csmaster.orderSys.dto.OrderRequest;

@Component
public class DeliveryScheduler {

	@RabbitListener(queues = "${spring.rabbitmq.queue")
	public void consumeMessageFromQueue(OrderRequest order) {
		
	}

}
