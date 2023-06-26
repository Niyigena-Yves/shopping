package com.online.shopping.validator.routines;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidator {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private static EmailValidator instance;

    private EmailValidator() {
        // private constructor to enforce Singleton pattern
    }

    public static EmailValidator getInstance() {
        if (instance == null) {
            synchronized (EmailValidator.class) {
                if (instance == null) {
                    instance = new EmailValidator();
                }
            }
        }
        return instance;
    }

    public boolean isValid(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}

