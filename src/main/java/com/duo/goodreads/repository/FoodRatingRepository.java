/**
 * 
 */
package com.duo.goodreads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duo.goodreads.model.FoodRating;
import com.duo.goodreads.model.FoodRatingKey;
import com.duo.goodreads.model.User;

/**
 *
 *
 * @author Matthew Mazzotta
 */
public interface FoodRatingRepository extends JpaRepository<FoodRating, FoodRatingKey> {
	
	List<FoodRating> findByUser(User user);
}