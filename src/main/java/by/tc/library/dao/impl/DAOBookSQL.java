package by.tc.library.dao.impl;

import by.tc.library.bean.UserInfo;
import by.tc.library.bean.book.Book;
import by.tc.library.dao.DAOException;
import by.tc.library.dao.DaoBook;
import by.tc.library.dao.connection.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOBookSQL implements DaoBook {
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String ADD_BOOK_SQL = "insert " +
            "into library_bd.books (b_name, b_prod_year," +
            "b_rating, b_isbn, b_isbn, authors_a_id)" +
            "values (?,?,?,?,?,?,?)";
    private static final String GET_BOOKS_SQL = "select b_id,b_name,b_prod_year,b_rating,b_isbn,(select g_name from genres where books.genres_g_id = genres.g_id),(select a_name from authors where books.authors_a_id=authors.a_id)" +
            ",(select publishing_office_name from publishing_offices where books.b_id_publ = publishing_offices.id_publishing_office) from books";

    @Override
    public ArrayList<Book> getListOfBooks() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Book> books = new ArrayList<>();

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(GET_BOOKS_SQL);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                books.add(new Book(resultSet.getInt(1),resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getFloat(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8)));
            }
        }catch (SQLException e){
            throw new DAOException(e.getMessage());
        }
        finally {
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
        return books;
    }

    @Override
    public boolean addBook(Book book) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(ADD_BOOK_SQL);
            preparedStatement.setString(1,book.getB_name());
            //preparedStatement.setInt(2,book.getGenres_id());
            preparedStatement.setString(3,book.getB_name());
            preparedStatement.setInt(4,book.getProd_year());
            preparedStatement.setFloat(5,book.getRating());
            preparedStatement.setString(6,book.getB_isbn());
            //preparedStatement.setInt(7,book.getAuthor_id());
        } catch (SQLException e) {
            throw new DAOException("Connection error: " + e);
        }
        finally {
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
    public boolean deleteBook() {
        return false;
    }
}
