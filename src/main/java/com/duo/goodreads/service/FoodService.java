package com.duo.goodreads.service;

import com.duo.goodreads.model.Food;
import com.duo.goodreads.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;
    public List<Food> findAll(){
        return foodRepository.findAll();
    }
}
