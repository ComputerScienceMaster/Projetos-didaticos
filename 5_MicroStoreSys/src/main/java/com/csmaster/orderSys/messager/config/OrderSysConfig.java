package com.csmaster.orderSys.messager.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderSysConfig{

	@Value("${spring.rabbitmq.queue")
	private String queue;
	
	@Value("${spring.rabbitmq.queue")
	private String nomeExchange;
	

	@Value("${spring.rabbitmq.routing-key")
	private String routingKey;

    
    @Bean
    Queue queue() {
        return QueueBuilder.durable(queue).build();
    }
    @Bean
    DirectExchange exchange() {
        return new DirectExchange(nomeExchange); 
    }


    @Bean
    Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
    }


}
