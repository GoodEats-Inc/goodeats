package com.duo.goodreads.controller;

import com.duo.goodreads.repository.FoodRepository;
import com.duo.goodreads.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

		return "web/home";
	}

	@RequestMapping("/css/styles.css")
	public String css() {
		return "web/css/styles.css";
	}

	@RequestMapping("/my_list")
	public String myList() {
		return "web/my_list";
	}

	@RequestMapping("/top_rated")
	public String topRated() {
		return "web/top_rated";
	}
}