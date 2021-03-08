package by.library.JWD_FinalTask.controller.commands;

import by.library.JWD_FinalTask.dao.DAOOperation;
import by.library.JWD_FinalTask.dao.impl.DAOAuthorize;
import by.library.JWD_FinalTask.entity.users.User;
import by.library.JWD_FinalTask.entity.users.impl.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", value = "/AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("login_button")!=null){
            String username = request.getParameter("username_txt");
            String password = request.getParameter("password_txt");
            User user = new DAOAuthorize().checkCredentials(username,password);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
