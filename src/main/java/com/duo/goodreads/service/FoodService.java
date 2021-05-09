package com.duo.goodreads.service;

import com.duo.goodreads.model.Food;
import com.duo.goodreads.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
	
    @Autowired
    FoodRepository foodRepository;
    
    public List<Food> findAll(){
        return foodRepository.findAll();
    }
    
    public Optional<Food> findById(long id) {
    	return foodRepository.findById(id);
    }
}