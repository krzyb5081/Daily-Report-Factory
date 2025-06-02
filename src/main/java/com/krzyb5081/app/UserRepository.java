package com.krzyb5081.app;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krzyb5081.app.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
}