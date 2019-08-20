package com.wipro.practice.SpringBootPractice.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/getName")
	private String getName() {
		return "Bikas Kumar";

	}
	
	@RequestMapping("/index")
	private Model getIndexPage(Model model) {
		return model;

	}
	@RequestMapping("/welcome")
	private Model getWelcomePage(Model model) {
		return model;

	}
	
}
