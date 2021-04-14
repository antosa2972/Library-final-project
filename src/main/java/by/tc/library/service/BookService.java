package by.tc.library.service;

import by.tc.library.bean.book.Book;

import java.util.ArrayList;

public interface BookService {
    public ArrayList<Book> getListOfBooks() throws ServiceException;
    public boolean addBook(Book book) throws ServiceException;
    public boolean deleteBook();
}
