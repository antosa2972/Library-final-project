package by.tc.library.controller.command.impl;

import by.tc.library.bean.UserInfo;
import by.tc.library.controller.command.Command;
import by.tc.library.service.ServiceException;
import by.tc.library.service.ServiceProvider;
import by.tc.library.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration implements Command {
    private static final String USERNAME_PARAM = "username_reg";
    private static final String EMAIL_PARAM = "email";
    private static final String PASSWORD_PARAM = "password_reg";
    private static final String PASSWORD_CONFIRM_PARAM = "password_confirm";
    private static final String TELEPHONE_PARAM = "telephone";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String CHECKBOX_PARAM = "checkbox";
    private static final String CHECKBOX_ON = "on";
    private static final String LOAD_MAIN_PAGE = "Controller?command=loadmainpage";
    private static final String REG_PAGE_PATH = "/WEB-INF/jsp/firs_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(USERNAME_PARAM);
        String email = request.getParameter(EMAIL_PARAM);
        String password = request.getParameter(PASSWORD_PARAM);
        String passwordConfirm = request.getParameter(PASSWORD_CONFIRM_PARAM);
        String telephone = request.getParameter(TELEPHONE_PARAM);
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String checkValue = request.getParameter(CHECKBOX_PARAM);
        boolean isAdmin = false;

        if (checkValue != null && checkValue.equals(CHECKBOX_ON)) {
            isAdmin = true;
        }
        UserInfo userInfo = new UserInfo(username, telephone, password, email, name, surname, isAdmin);
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        UserService userService = serviceProvider.getUserService();

        try {
            if (userService.registration(userInfo)) {
                response.sendRedirect(LOAD_MAIN_PAGE);
            }
        } catch (ServiceException e) {
            request.setAttribute("message", e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(REG_PAGE_PATH);
            requestDispatcher.forward(request, response);
        }
    }
}
