package com.kafka.api.controllers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class MessageController {
	
	private KafkaTemplate<String, String> template;
	
	public MessageController(KafkaTemplate<String, String> template) {
		super();
		this.template = template;
	}


	@PostMapping("/publish")
	public void publish(@RequestParam String msg) {
		template.send("topic", msg);
	}

}
