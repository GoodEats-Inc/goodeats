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
	@JoinColumn(name="ID_MEAL")
	private Meal meal;
	
	int rating;

	public FoodRatingKey getId() { return id; }

	public void setId(FoodRatingKey id) { this.id = Objects.requireNonNull(id); }

	public User getUser() { return user; }

	public void setUser(User user) { this.user = Objects.requireNonNull(user); }

	public Meal getMeal() { return meal; }

	public void setMeal(Meal meal) { this.meal = Objects.requireNonNull(meal); }

	public int getRating() { return rating; }

	public void setRating(int rating) { this.rating = rating; }
}