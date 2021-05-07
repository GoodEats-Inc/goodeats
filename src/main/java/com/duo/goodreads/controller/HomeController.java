package com.duo.goodreads.controller;

import com.duo.goodreads.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private @Autowired
	FoodService foodService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("foods", foodService.findAll());
		return "html/home";
	}

	@RequestMapping("/my_list")
	public String myList() {
		return "html/my_list";
	}

	@RequestMapping("/top_rated")
	public String topRated() {
		return "html/top_rated";
	}
}