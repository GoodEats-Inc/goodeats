/**
 * 
 */
package com.duo.goodreads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duo.goodreads.model.FoodRating;
import com.duo.goodreads.model.FoodRatingKey;

/**
 *
 *
 * @author Matthew Mazzotta
 */
public interface FoodRatingRepository extends JpaRepository<FoodRating, FoodRatingKey> {
}