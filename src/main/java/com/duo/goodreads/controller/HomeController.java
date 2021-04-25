package com.duo.goodreads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "html/home";
	}

	@RequestMapping("/index")
	public String index() {
		return "html/index";
	}
}