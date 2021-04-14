package by.tc.library.dao;

import by.tc.library.bean.book.Book;

import java.util.ArrayList;

public interface DaoBook {
    public ArrayList<Book> getListOfBooks() throws DAOException;
    public boolean addBook(Book book) throws DAOException;
    public boolean deleteBook();
}
