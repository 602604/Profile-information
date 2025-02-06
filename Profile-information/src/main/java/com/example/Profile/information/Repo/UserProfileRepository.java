package com.example.Profile.information.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Profile.information.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByEmail(String email);
}

