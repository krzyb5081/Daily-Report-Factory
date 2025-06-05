package com.krzyb5081.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krzyb5081.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}