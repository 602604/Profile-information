package com.example.Profile.information.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Profile.information.Repo.UserRepository;
import com.example.Profile.information.Service.UserService;
import com.example.Profile.information.model.User;

@Controller
@RequestMapping("/profile")
public class UserController {
	
	@Autowired
    private UserService userService;
	
    @GetMapping("/{id}")
    public String viewProfile(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/update/{id}")
    public String updateProfile(@PathVariable Long id, @ModelAttribute User user) {
        userService.updateProfile(id, user);
        return "redirect:/profile/" + id;
    }
    
}

