package by.tc.JWD_WebTask.dao;

import by.tc.JWD_WebTask.model.User;
import org.apache.log4j.Logger;

import java.sql.*;

public class UserDao {
    private static Logger logger = Logger.getLogger(UserDao.class);
    private static String URL = "jdbc:mysql://localhost:3306/library_bd?useSSL=false&serverTimezone=UTC";
    private static String name = "antosa2972";
    private static String pass = "55Ssteam29";
    public static int registerUserC(User user)throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO USERS (u_username," +
                "u_telephone,u_password,u_email,u_name,u_surname) VALUES " +
                "(?,?,?,?,?,?);";
        int result = 0;
        try{
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection connection  = DriverManager.getConnection(URL,name,pass);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getTelephone());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getName());
            preparedStatement.setString(6,user.getSurname());

            result = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            logger.error("Error:" + e.getErrorCode());
        }
        return result;
    }
}
