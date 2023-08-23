package com.csm.MedicalCareFinances.Messaging;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConfiguration {

        private AmqpAdmin amqpAdmin;

        public RabbitMQConfiguration(AmqpAdmin amqpAdmin){
                this.amqpAdmin = amqpAdmin;
        }

        private Queue createQueue(String nomeFila){
                return new Queue(nomeFila, true, false, false);
        }

        private DirectExchange getDirectExchange() {
                return new DirectExchange(QueueConfigurationParameters.EXCHANGE_NAME);
        }

        private Binding bindQueues(Queue fila, DirectExchange troca){
                return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
        }

        @PostConstruct
        private void setupRabbitMQConfiguration(){
                Queue queueOrders = this.createQueue(QueueConfigurationParameters.ORDERS);
                Queue queueAppointments = this.createQueue(QueueConfigurationParameters.APPOINTMENTS);
                Queue queueExaminations   = this.createQueue(QueueConfigurationParameters.EXAMINATIONS);

                DirectExchange exchange = this.getDirectExchange();

                Binding bindOrders = this.bindQueues(queueOrders, exchange);
                Binding bindAppointments = this.bindQueues(queueAppointments, exchange);
                Binding bindExaminations = this.bindQueues(queueExaminations, exchange);

                this.amqpAdmin.declareQueue(queueOrders);
                this.amqpAdmin.declareQueue(queueAppointments);
                this.amqpAdmin.declareQueue(queueExaminations);

                this.amqpAdmin.declareExchange(exchange);

                this.amqpAdmin.declareBinding(bindOrders);
                this.amqpAdmin.declareBinding(bindAppointments);
                this.amqpAdmin.declareBinding(bindExaminations);
        }
}
