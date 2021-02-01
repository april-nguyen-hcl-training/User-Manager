package com.hcl.usermanager.controller;

import com.hcl.usermanager.domain.Account;
import com.hcl.usermanager.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountController extends HttpServlet {

    public AccountController() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = AccountService.getById((Long) req.getSession().getAttribute("userId"));
        req.setAttribute("account", account);
        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

}
