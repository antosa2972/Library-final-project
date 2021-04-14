package by.tc.library.controller.command.impl;

import by.tc.library.bean.book.Book;
import by.tc.library.controller.command.Command;
import by.tc.library.service.BookService;
import by.tc.library.service.ServiceException;
import by.tc.library.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowBooks implements Command {
    private static final String LIST_ATTR = "list";
    private static final String path = "/WEB-INF/jsp/catalogPage.jsp";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Book> bookArrayList = null;
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        BookService bookService = serviceProvider.getBookService();
        try {
            bookArrayList = bookService.getListOfBooks();
            request.setAttribute(LIST_ATTR,bookArrayList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
            requestDispatcher.forward(request,response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
