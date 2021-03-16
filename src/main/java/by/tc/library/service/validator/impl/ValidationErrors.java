package by.tc.library.service.validator.impl;

public enum ValidationErrors {
    EMPTY_USERNAME("Enter username!"),
    EMPTY_PASSWORD("Enter password!"),
    EMPTY_EMAIL("Enter email!"),
    SHORT_PASSWORD("The password is too short!"),
    LONG_PASSWORD("The password is too long!"),
    LONG_USERNAME("The username is too long!"),
    INVALID_USERNAME("Username must contain only letters and numbers!"),
    INVALID_EMAIL("Invalid format of email!");
    private final String title;
    ValidationErrors(String title) {
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }

}