package com.example.Profile.information.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Profile.information.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

