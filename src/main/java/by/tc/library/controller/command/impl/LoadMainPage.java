package by.tc.library.controller.command.impl;

import by.tc.library.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LoadMainPage implements Command {
    private static final String MAIN_PAGE_PATH = "WEB-INF/jsp/main_page.jsp";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(MAIN_PAGE_PATH);
        requestDispatcher.forward(request,response);
    }
}
