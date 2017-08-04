package com.websystique.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {


	@RequestMapping("/new/")
	public String welcome() {//Welcome page, non-rest
		return "NewFile";
	}

	

	
}
