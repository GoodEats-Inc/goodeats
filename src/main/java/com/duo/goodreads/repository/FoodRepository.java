package com.duo.goodreads.repository;

import com.duo.goodreads.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
