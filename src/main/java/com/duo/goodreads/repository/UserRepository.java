package com.duo.goodreads.repository;

import com.duo.goodreads.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}