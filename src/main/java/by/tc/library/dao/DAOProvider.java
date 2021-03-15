package by.tc.library.dao;

import by.tc.library.dao.impl.DAOUserSQL;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final DAOUser daoUser = new DAOUserSQL();

    private DAOProvider(){}

    public static DAOProvider getInstance(){
        return instance;
    }
    public DAOUser getDaoUser(){
        return daoUser;
    }
}
