package by.tc.library.dao;

import by.tc.library.bean.UserInfo;

public interface DAOUser {
    public boolean registration(UserInfo userInfo) throws DAOException;
    public UserInfo authorization(UserInfo userInfo) throws DAOException;
}
