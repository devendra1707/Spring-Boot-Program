package com.sprinboot.rabitmq.servicer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sprinboot.rabitmq.model.Employee;



@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${springboot.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${springboot.rabbitmq.routingkey}")
	private String routingkey;	
	
	
	
	
	public void send(Employee employee) {
		amqpTemplate.convertAndSend(exchange, routingkey, employee);
		System.out.println("----------------------------------------");
		System.out.println("Send msg To Rabit MQ = " + employee);
		System.out.println("----------------------------------------");
		
	    
	}
}