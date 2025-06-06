package com.krzyb5081.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krzyb5081.app.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUserName(String userName);
}