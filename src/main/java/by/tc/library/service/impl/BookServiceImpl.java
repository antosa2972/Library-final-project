package by.tc.library.service.impl;

import by.tc.library.bean.book.Book;
import by.tc.library.dao.DAOException;
import by.tc.library.dao.DAOProvider;
import by.tc.library.dao.DaoBook;
import by.tc.library.service.BookService;
import by.tc.library.service.ServiceException;

import java.util.ArrayList;

public class BookServiceImpl implements BookService {

    @Override
    public ArrayList<Book> getListOfBooks() throws ServiceException {
        DAOProvider daoProvider = DAOProvider.getInstance();
        DaoBook daoBook = daoProvider.getDaoBook();
        ArrayList<Book> bookArrayList = null;
        try {
            try {
                bookArrayList = daoBook.getListOfBooks();
            }catch (DAOException e){
                throw new ServiceException("Error while showing books" + e.getMessage());
            }
        }catch (ServiceException e){
            throw new ServiceException(e);
        }
        return bookArrayList;
    }

    @Override
    public boolean addBook(Book book) throws ServiceException {
        DAOProvider daoProvider = DAOProvider.getInstance();
        DaoBook daoBook = daoProvider.getDaoBook();
        try {
            try {
                boolean success = daoBook.addBook(book);
                return success;
            } catch (DAOException e) {
                throw new ServiceException("Error while adding the book:" + e.getMessage());
            }
        } catch (ServiceException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteBook() {
        return false;
    }
}
