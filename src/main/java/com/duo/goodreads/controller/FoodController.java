package com.duo.goodreads.controller;

import com.duo.goodreads.model.Food;
import com.duo.goodreads.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {
    private @Autowired FoodRepository foodRepository;

    @PostMapping("/addfood")
    public String addFood(@ModelAttribute("food") Food food, BindingResult result) {
        if (result.hasErrors()) {
            return "home";
        }

        foodRepository.save(food);

        return "redirect:/home2";
    }

    @RequestMapping("/foods")
    private String listFood(Model model){
        model.addAttribute("foods", foodRepository.findAll());
        return "home";
    }
}
