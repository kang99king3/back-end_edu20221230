package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public String index() {
		System.out.println("index");
		return "index";
	}
	
	@GetMapping(value="/home")
	public String home(Model model) {
		System.out.println("home");
		model.addAttribute("imgname", "/img/arrow.png");
		return "thymeleaf/home";
//		return "home";
	}

	
	
}




