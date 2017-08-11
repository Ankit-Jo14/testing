package com.websystique.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {


	@RequestMapping("/")
	public String welcome() {//Welcome page, non-rest
		System.out.println("inside");
		return "home";
	}

	

	
}
