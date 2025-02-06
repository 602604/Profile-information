package com.example.Profile.information.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile getProfileByEmail(String email) {
        return userProfileRepository.findByEmail(email);
    }

    public UserProfile updateProfile(UserProfile updatedProfile) {
        UserProfile existingProfile = userProfileRepository.findByEmail(updatedProfile.getEmail());
        if (existingProfile == null) {
            throw new IllegalArgumentException("Profile not found.");
        }
        existingProfile.setName(updatedProfile.getName());
        return userProfileRepository.save(existingProfile);
    }

    public void changePassword(String email, String currentPassword, String newPassword) {
        UserProfile profile = userProfileRepository.findByEmail(email);
        if (profile == null || !profile.getPassword().equals(currentPassword)) {
            throw new IllegalArgumentException("Invalid credentials.");
        }
        profile.setPassword(newPassword);
        userProfileRepository.save(profile);
    }
}

