package com.example.camelrabbitmq.producer;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.camelrabbitmq.model.Corporation;

@RestController
public class SpringRabbitMQController {
	
	@Produce(uri = "direct:startQueuePoint")
	private ProducerTemplate template;
	
	@RequestMapping(value = "/corporation", method = RequestMethod.GET)
	public String create(@RequestParam String name, @RequestParam String location, @RequestParam int noofemployee) {

		Corporation corporation=new Corporation();
		corporation.setName(name);
		corporation.setNoofemployee(noofemployee);
		corporation.setLocation(location);


		template.asyncSendBody(template.getDefaultEndpoint(), corporation);
		return "Successfully Executed...";
	}
}
