package com.websystique.springmvc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import com.websystique.springmvc.domain.Message;

@RestController
public class HelloWorldRestController {
//	@RequestMapping("/")
//	public String welcome() {//Welcome page, non-rest
//		return "index";
//	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {//REST Endpoint.

		Message msg = new Message(player, "Hello " + player);
		return msg;
	}

	
}
