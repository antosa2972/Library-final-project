package by.tc.library.controller.command.impl;

import by.tc.library.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut implements Command {
    private static final String LOAD_MAIN_PAGE = "Controller?command=loadmainpage";
    private static final String AUTH_ATTR = "auth";
    private static final String USERNAME_ATTR = "login";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if(httpSession!=null){
            httpSession.removeAttribute(AUTH_ATTR);
            httpSession.removeAttribute(USERNAME_ATTR);
        }
        response.sendRedirect(LOAD_MAIN_PAGE);
    }
}
