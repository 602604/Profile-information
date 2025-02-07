package com.example.Profile.information.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Profile.information.Repo.UserProfileRepository;
import com.example.Profile.information.model.UserProfile;

@RestController
@RequestMapping("/api/files")
public class FileController {

	  private final String uploadDir = "uploads/";

	    @Autowired
	    private UserProfileRepository userProfileRepository;

	    @PostMapping("/upload")
	    public ResponseEntity<String> uploadProfilePicture(@RequestParam("file") MultipartFile file, @RequestParam("email") String email) {
	        UserProfile profile = userProfileRepository.findByEmail(email);
	        if (profile == null) {
	            return ResponseEntity.notFound().build();
	        }

	        try {
	            Path path = Paths.get(uploadDir + file.getOriginalFilename());
	            Files.write(path, file.getBytes());
	            profile.setProfilePicturePath(path.toString());
	            userProfileRepository.save(profile);
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Error uploading file.");
	        }

	        return ResponseEntity.ok("Profile picture uploaded successfully.");
	    }

	    @DeleteMapping("/remove")
	    public ResponseEntity<String> removeProfilePicture(@RequestParam("email") String email) {
	        UserProfile profile = userProfileRepository.findByEmail(email);
	        if (profile == null) {
	            return ResponseEntity.notFound().build();
	        }

	        try {
	            Files.deleteIfExists(Paths.get(profile.getProfilePicturePath()));
	            profile.setProfilePicturePath(null);
	            userProfileRepository.save(profile);
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Error removing file.");
	        }

	        return ResponseEntity.ok("Profile picture removed successfully.");
	    }
}

