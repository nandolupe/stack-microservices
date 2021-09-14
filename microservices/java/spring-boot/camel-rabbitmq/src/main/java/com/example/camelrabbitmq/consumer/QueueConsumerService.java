package com.example.camelrabbitmq.consumer;

import org.apache.camel.Consume;
import org.apache.camel.ConsumerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumerService {
	
	@Consume(uri = "direct:startQueuePoint")
	private ConsumerTemplate template;
	
	@Autowired
	private Environment env;
	
	public void consumer() {
		template.receiveBody("rabbitmq://" + env.getProperty("rabbitmq.address") + ":"+ env.getProperty("rabbitmq.port") + "/myqueue.exchange?queue=myqueue.queue&autoDelete=false");
	}
}
