package com.duo.goodreads.repository;

import com.duo.goodreads.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
