package com.rabitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

	@Bean
	Queue marketingQueue() {
		return new Queue("marketingQueue", false);
	}

	@Bean
	Queue financeQueue() {
		return new Queue("financeQueue", false);
	}

	@Bean
	Queue adminQueue() {
		return new Queue("adminQueue", false);
	}

	@Bean
	Queue allQueue() {
		return new Queue("allQueue", false);
	}

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange("topic-exchange");
	}
	
	@Bean
	Binding marketingBinding(Queue marketingQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(marketingQueue).to(topicExchange).with("queue.marketing");
	}
	
	@Bean
	Binding financeBinding(Queue financeQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(financeQueue).to(topicExchange).with("queue.finance");
	}
	
	@Bean
	Binding adminBinding(Queue adminQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(adminQueue).to(topicExchange).with("queue.admin");
	}
	
	@Bean
	Binding allBinding(Queue allQueue, TopicExchange topicExchange) {
		return BindingBuilder.bind(allQueue).to(topicExchange).with("queue.*");
	}


	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
		return simpleMessageListenerContainer;
	}

	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}

