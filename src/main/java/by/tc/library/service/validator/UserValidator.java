package by.tc.library.service.validator;

import by.tc.library.bean.UserInfo;
import by.tc.library.service.ServiceException;

public interface UserValidator {
    boolean checkAuthData(UserInfo userInfo) throws ServiceException;
    boolean checkRegData(UserInfo userInfo) throws ServiceException;
}
