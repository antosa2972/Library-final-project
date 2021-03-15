package by.tc.library.service.validator.impl;

import by.tc.library.bean.UserInfo;
import by.tc.library.service.ServiceException;
import by.tc.library.service.validator.UserValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorImpl implements UserValidator {
    private static final String CHAR_AND_NUM = "[A-Z0-9]+";
    private static final String EMAIL_FORMAT = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 30;

    @Override
    public boolean checkAuthData(UserInfo userInfo) throws ServiceException {
        if (userInfo.getUsername().isEmpty() || userInfo.getUsername() == null) {
            throw new ServiceException(ValidationErrors.EMPTY_USERNAME.getTitle());
        }
        if (userInfo.getPassword().isEmpty() || userInfo.getPassword() == null) {
            throw new ServiceException(ValidationErrors.EMPTY_PASSWORD.getTitle());
        }
        if (userInfo.getPassword().length() < MIN_LENGTH) {
            throw new ServiceException(ValidationErrors.SHORT_PASSWORD.getTitle());
        }
        if (userInfo.getPassword().length() > MAX_LENGTH) {
            throw new ServiceException(ValidationErrors.LONG_PASSWORD.getTitle());
        }
        if (userInfo.getUsername().length() > MAX_LENGTH) {
            throw new ServiceException(ValidationErrors.LONG_USERNAME.getTitle());
        }
        Pattern usernamePattern = Pattern.compile(CHAR_AND_NUM);
        Matcher usernameMatcher = usernamePattern.matcher(userInfo.getUsername());

        if (!usernameMatcher.find()) {
            throw new ServiceException(ValidationErrors.INVALID_USERNAME.getTitle());
        }

        return true;
    }

    @Override
    public boolean checkRegData(UserInfo userInfo) throws ServiceException {
        if (checkAuthData(userInfo)) {
            if(userInfo.getEmail().isEmpty() || userInfo.getEmail() == null) {
                throw new ServiceException(ValidationErrors.EMPTY_EMAIL.getTitle());
            }
            Pattern emailPattern = Pattern.compile(EMAIL_FORMAT);
            Matcher emailMatcher = emailPattern.matcher(userInfo.getEmail());
            if(!emailMatcher.find()){
                //throw new ServiceException(ValidationErrors.INVALID_EMAIL.getTitle());
            }
        }
        return true;
    }
}
