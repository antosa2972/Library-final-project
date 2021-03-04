package by.library.JWD_Web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface CommandExecutor {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
