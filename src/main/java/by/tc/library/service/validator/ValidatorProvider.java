package by.tc.library.service.validator;

import by.tc.library.service.validator.impl.UserValidatorImpl;

public class ValidatorProvider {
    private static final ValidatorProvider instance = new ValidatorProvider();
    private ValidatorProvider(){}
    private final UserValidator userValidator = new UserValidatorImpl();

    public static ValidatorProvider getInstance() {
        return instance;
    }

    public UserValidator getUserValidator() {
        return userValidator;
    }
}
