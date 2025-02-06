package com.example.Profile.information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.information.Repo.UserProfileRepository;
import com.example.Profile.information.model.PasswordChangeRequest;
import com.example.Profile.information.model.UserProfile;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeRequest passwordRequest) {
        UserProfile profile = userProfileRepository.findByEmail(passwordRequest.getEmail());
        if (profile == null || !profile.getPassword().equals(passwordRequest.getCurrentPassword())) {
            return ResponseEntity.badRequest().body("Current password is incorrect.");
        }
        profile.setPassword(passwordRequest.getNewPassword());
        userProfileRepository.save(profile);
        return ResponseEntity.ok("Password changed successfully.");
    }
}

