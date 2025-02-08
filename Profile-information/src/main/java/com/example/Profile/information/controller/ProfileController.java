package com.example.Profile.information.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.information.Repo.UserProfileRepository;
import com.example.Profile.information.model.UserProfile;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
	
	@Autowired
	private UserProfileRepository userProfileRepository;


	@GetMapping("/{email}")
    public ResponseEntity<UserProfile> getProfile(@PathVariable String email) {
    	UserProfile profile = userProfileRepository.findByEmail(email);
        if (profile == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(profile);
    }
    
    @PutMapping
    public ResponseEntity<String> updateProfile(@RequestBody UserProfile updatedProfile) {
        UserProfile existingProfile = userProfileRepository.findByEmail(updatedProfile.getEmail());
        if (existingProfile == null) {
            return ResponseEntity.notFound().build();
        }
        existingProfile.setName(updatedProfile.getName());
        userProfileRepository.save(existingProfile);
        return ResponseEntity.ok("Profile updated successfully.");
    }
}

