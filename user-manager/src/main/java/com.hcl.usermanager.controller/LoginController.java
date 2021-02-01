package com.hcl.usermanager.controller;

import com.hcl.usermanager.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    public LoginController() throws IOException{ }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").include(req, resp);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (AccountService.validLogin(username, password)) {
            Long userId = AccountService.getAccountId(username);
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", userId);

            request.setAttribute("account", AccountService.getById(userId));
            request.getRequestDispatcher("account.jsp").include(request,response);
        } else if (AccountService.usernameExists(username)) {
            request.setAttribute("username", username);
            request.setAttribute("loginAlert", "Invalid Password!");
            request.getRequestDispatcher("login.jsp").include(request,response);
        } else {
            request.setAttribute("username", username);
            request.setAttribute("loginAlert", "Username does not exist!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }

}
