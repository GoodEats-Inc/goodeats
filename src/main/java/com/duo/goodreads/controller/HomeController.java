package com.duo.goodreads.controller;

import com.duo.goodreads.model.Food;
import com.duo.goodreads.model.FoodRating;
import com.duo.goodreads.model.User;
import com.duo.goodreads.service.FoodRatingService;
import com.duo.goodreads.service.FoodService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private @Autowired
	FoodService foodService;
	
	@Autowired
	private FoodRatingService foodRatingService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("foods", foodService.findAll());
		
		//esempio 
		//String username = SecurityContextHolder.getContext().getAuthentication().getName();
		//if(!username.equals("anonymousUser"))
		//	model.addAttribute("username", username);
		return "html/home";
	}

	@RequestMapping("/my_list")
	public String myList(Model model) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = new User();
		user.setUsername(username);
		
		if(!username.equals("anonymousUser")) {
			List<FoodRating> foodRatings = foodRatingService.findByUser(user);
			Map<Food, Integer> foodRatingsMap = foodRatings.stream()
															.collect(Collectors.toMap(FoodRating::getFood, FoodRating::getRating));
			model.addAttribute("foodRatingsMap", foodRatingsMap);
		}
		
		return "html/my_list";
	}

	@RequestMapping("/top_rated")
	public String topRated(Model model) {
		return "html/top_rated";
	}
}