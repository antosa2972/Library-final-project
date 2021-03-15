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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Authorization implements Command {
    private static final String USERNAME_PARAM = "username";
    private static final String PASSWORD_PARAM = "password";
    private static final String LOAD_MAIN_PAGE = "Controller?command=loadmainpage";
    private static final String AUTH_ATTRIBUTE = "auth";
    private static final String AUTH_PAGE_PATH = "WEB-INF/jsp/authorization.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(USERNAME_PARAM);
        String password = request.getParameter(PASSWORD_PARAM);

        UserInfo userInfo = new UserInfo(username,password);
        ServiceProvider serviceProvider = ServiceProvider.getInstance();
        UserService userService = serviceProvider.getUserService();

        UserInfo authorizedUser = null;

        try {
            authorizedUser = userService.authorization(userInfo);
            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute(AUTH_ATTRIBUTE,true);
            response.sendRedirect(LOAD_MAIN_PAGE);

        }catch (ServiceException e){
            request.setAttribute("message",e.getMessage());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(AUTH_PAGE_PATH);
            requestDispatcher.forward(request,response);
        }
    }
}
