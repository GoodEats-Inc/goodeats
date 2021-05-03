/**
 * 
 */
package com.duo.goodreads.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 *
 * @author Matthew Mazzotta
 */
@Entity
public class FoodRating {

	@EmbeddedId
	private FoodRatingKey id;
	
	@ManyToOne
	@MapsId("username")
	@JoinColumn(name="username")
	private User user;
	
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name="id_food")
	private Food food;
	
	int rating;

	public FoodRatingKey getId() { return id; }

	public void setId(FoodRatingKey id) { this.id = Objects.requireNonNull(id); }

	public User getUser() { return user; }

	public void setUser(User user) { this.user = Objects.requireNonNull(user); }

	public Food getMeal() { return food; }

	public void setMeal(Food food) { this.food = Objects.requireNonNull(food); }

	public int getRating() { return rating; }

	public void setRating(int rating) { this.rating = rating; }
}