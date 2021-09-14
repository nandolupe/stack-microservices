package com.example.camelrabbitmq;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.example.camelrabbitmq.model.Corporation;

@Component
public class RabbitMQRouting extends RouteBuilder {
	
	@Autowired
	private Environment env;
	
	@Override
	public void configure() throws Exception {

		JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Corporation.class);

		from("direct:startQueuePoint")
			.id("idOfQueueHere")
			.log(">>> ${body.name}")
			.log(">>> ${body.location}")
			.log(">>> ${body}")
			.marshal(jsonDataFormat)
			.to("rabbitmq://" + env.getProperty("rabbitmq.address") + ":"+ env.getProperty("rabbitmq.port") + "/myqueue.exchange?queue=myqueue.queue&autoDelete=false").end();
	}
	
}
