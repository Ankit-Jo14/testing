package com.websystique.springmvc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;

import com.websystique.springmvc.domain.Message;
import com.websystique.springmvc.model.Cultivar;
import com.websystique.springmvc.model.CultivarHome;

@RestController
public class HelloWorldRestController {
	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		return "home.html";
	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {//REST Endpoint.
        try{CultivarHome home = new CultivarHome();
        Cultivar k = home.findById(2);
        }catch(Exception e){
        	System.out.println(e);
        }
		Message msg = new Message(player, "Hello " + player);
		return msg;
	}

	
}
