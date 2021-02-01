package com.hcl.usermanager.controller;


import com.hcl.usermanager.domain.Account;
import com.hcl.usermanager.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {

    public RegisterController() { }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").include(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account input = (Account) request.getAttribute("accountInput");
        String username = request.getParameter("username");

        if (AccountService.usernameExists(input.getUsername())) {
            request.setAttribute("usernameAlert", "Username is taken!");
            request.getRequestDispatcher("register.jsp").include(request,response);
        } else {
            Account addedAccount = AccountService.add(input);

            Long userId = AccountService.getAccountId(username);
            request.getSession(true).setAttribute("userId", userId);

            request.setAttribute("accountSuccessAlert", "Account Created Successfully!");
            request.setAttribute("account", AccountService.getById(userId));
            request.getRequestDispatcher("account.jsp").include(request,response);
        }
    }

}
