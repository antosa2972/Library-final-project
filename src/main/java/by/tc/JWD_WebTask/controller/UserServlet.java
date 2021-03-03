package by.tc.JWD_WebTask.controller;

import by.tc.JWD_WebTask.dao.UserDao;
import by.tc.JWD_WebTask.model.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/register")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String name = request.getParameter("username");
        String surname = request.getParameter("username");
        String number = request.getParameter("username");
        String email = request.getParameter("username");
        String password = request.getParameter("username");
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setTelephone(number);
        user.setEmail(email);
        user.setPassword(password);
        try {
            UserDao.registerUserC(user);
        } catch (ClassNotFoundException e) {
            Logger logger = Logger.getLogger(UserServlet.class);
            logger.error("Error: " + e.getMessage());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registration_success.jsp");
        dispatcher.forward(request,response);
    }
}
