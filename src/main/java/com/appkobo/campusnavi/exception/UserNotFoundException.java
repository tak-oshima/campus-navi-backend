package com.appkobo.campusnavi.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String email) {
        super(String.format("User with email \"%s\" could not be found", email));
    }
}
