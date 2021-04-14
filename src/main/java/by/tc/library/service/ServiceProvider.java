package by.tc.library.service;

import by.tc.library.service.impl.BookServiceImpl;
import by.tc.library.service.impl.UserServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final UserService userService = new UserServiceImpl();
    private final BookService bookService = new BookServiceImpl();
    private ServiceProvider(){}

    public static ServiceProvider getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public BookService getBookService() {
        return bookService;
    }
}
