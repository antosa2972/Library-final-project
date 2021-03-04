package by.library.JWD_Web.dao;

import by.library.JWD_Web.entity.RegInfo;
import by.library.JWD_Web.entity.User;

public interface AccountDAO {
    public User authorize(String login,String password);
    public int register(RegInfo regInfo);
}
