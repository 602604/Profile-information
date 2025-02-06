package com.example.Profile.infromasjon.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class HashingUtils {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }
}

