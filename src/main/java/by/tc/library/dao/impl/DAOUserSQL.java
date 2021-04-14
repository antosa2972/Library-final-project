package by.tc.library.dao.impl;

import by.tc.library.bean.AdministratorInfo;
import by.tc.library.bean.ClientInfo;
import by.tc.library.bean.UserInfo;
import by.tc.library.dao.DAOException;
import by.tc.library.dao.DAOUser;
import by.tc.library.dao.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUserSQL implements DAOUser {
    private static final String ADD_NEW_USER_SQL = "INSERT INTO library_bd.users (u_username, u_telephone, u_password, u_email, u_name, u_surname,user_role_ur_id) VALUES " +
            "(?,?,?,?,?,?,?)";
    private static final String SEARCH_USER_SQL = "SELECT * FROM users WHERE u_username = ? AND u_password = ?";
    private static int ADMIN_ID = 1;
    private static int USER_ID = 2;
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public boolean registration(UserInfo userInfo) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(ADD_NEW_USER_SQL);
            preparedStatement.setString(1, userInfo.getUsername());
            preparedStatement.setString(2, userInfo.getTelephone());
            preparedStatement.setString(3, userInfo.getPassword());
            preparedStatement.setString(4, userInfo.getEmail());
            preparedStatement.setString(5, userInfo.getName());
            preparedStatement.setString(6, userInfo.getSurname());
            if (userInfo.isAdmin()) {
                preparedStatement.setInt(7, ADMIN_ID);
            } else {
                preparedStatement.setInt(7, USER_ID);
            }
            try {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("Username already exists!");
            }
        } catch (SQLException e) {
            throw new DAOException("Connection error: " + e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (connection != null) {
                    try {
                        connection.close();
                        connectionPool.closeConnection(connection);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }

    @Override
    public UserInfo authorization(UserInfo userInfo) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        UserInfo authorized = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SEARCH_USER_SQL);
            preparedStatement.setString(1, userInfo.getUsername());
            preparedStatement.setString(2, userInfo.getPassword());

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int role_id = resultSet.getInt(8);
                if (role_id == 1) {
                    authorized = new AdministratorInfo(resultSet.getString(2), resultSet.getString(3),
                            resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), true, resultSet.getInt(1));
                } else {
                    authorized = new ClientInfo(resultSet.getString(2), resultSet.getString(3),
                            resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), false, "lol");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Connection error: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return authorized;
    }
}
