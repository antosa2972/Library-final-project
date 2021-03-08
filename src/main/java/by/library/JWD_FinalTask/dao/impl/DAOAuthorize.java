package by.library.JWD_FinalTask.dao.impl;

import by.library.JWD_FinalTask.dao.DAOOperation;
import by.library.JWD_FinalTask.entity.users.User;
import by.library.JWD_FinalTask.entity.users.impl.Client;

import java.sql.*;

public class DAOAuthorize implements DAOOperation {
    private Driver driver;
    private Connection connection;
    private String SQL_COMMAND = "select * from library_bd.users";
    public DAOAuthorize(){
        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, login, password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public User checkCredentials(String login,String password){
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_COMMAND);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                if (login.equals(resultSet.getString(2)) && password.equals(resultSet.getString(4))) {
                    user = new Client(resultSet.getString(2), resultSet.getString(3),
                            resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
                            resultSet.getString(7));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
