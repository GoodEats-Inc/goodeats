/**
 * 
 */
package com.duo.goodreads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duo.goodreads.model.FoodRating;
import com.duo.goodreads.model.User;
import com.duo.goodreads.repository.FoodRatingRepository;

/**
 *
 *
 * @author Matthew Mazzotta
 */
@Service
public class FoodRatingService {

	@Autowired
	private FoodRatingRepository foodRatingRepository;
	
	public List<FoodRating> findByUser(User user) {
		return foodRatingRepository.findByUser(user);
	}
}