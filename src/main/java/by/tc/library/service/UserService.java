package by.tc.library.service;

import by.tc.library.bean.UserInfo;

public interface UserService {
    boolean registration(UserInfo userInfo) throws ServiceException;
    UserInfo authorization(UserInfo userInfo) throws ServiceException;

}
