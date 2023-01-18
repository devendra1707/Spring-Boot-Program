package com.sprinboot.rabitmq.listender;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.sprinboot.rabitmq.model.Employee;

@Component
public class RabbitMQConsumer {


	@RabbitListener(queues = "${springboot.rabbitmq.queue}")
	public void recievedMessage(Employee employee) {
		System.out.println("----------------------------------------");
		System.out.println("Recieved Message From RabbitMQ: " + employee);
		System.out.println("----------------------------------------");


}











}
