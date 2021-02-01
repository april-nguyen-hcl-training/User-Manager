package com.hcl.usermanager.service;

import com.hcl.usermanager.domain.Account;

import javax.servlet.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class AccountInputValidator implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = request.getParameter("username");
        if(username != null) {
            String password = request.getParameter("password");
            String fName = request.getParameter("firstName");
            String lName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String bDay = request.getParameter("birthday");
            Date birthday = null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                birthday = format.parse(bDay);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            /* Verify that
             * username length >= 3username should can only contain letters, numbers, @, -, $, and _
             * password longer than 8 char and contains a number and a letter
             * birthday is not greater than today & 18 <= age <= 130 (using birthday)
             */
            boolean invalidInput = false;
            Pattern validUsername = Pattern.compile("[0-9a-zA-Z@_$-]{3,20}");
            Pattern validPassword = Pattern.compile("^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])*.{8,}$");
            if(!validUsername.matcher(username).matches()) {
                request.setAttribute("usernameAlert",
                  "Username must be 3-20 characters long, and can only contain letters, numbers, @, -, $, and _");
                invalidInput = true;
            }
            if(!validPassword.matcher(password).matches()) {
                request.setAttribute("passwordAlert",
                  "Password must be at least 8 characters, and contain a letter and a number!");
                invalidInput = true;
            }
            Calendar now = Calendar.getInstance();
            now.add(Calendar.YEAR, -18);
            Date eighteenYearsAgo = now.getTime();
            if(eighteenYearsAgo.before(birthday)) {
                request.setAttribute("birthdayAlert",
                  "You must be 18 or older!");
                invalidInput = true;
            }
            now = Calendar.getInstance();
            now.add(Calendar.YEAR, -130);
            Date oneHundredThirtyYearsAgo = now.getTime();
            if(oneHundredThirtyYearsAgo.after(birthday)) {
                request.setAttribute("birthdayAlert",
                  "Invalid Birthday! Are you really 130 or older?");
                invalidInput = true;
            }

            Account account = new Account(username, password, fName, lName, email, birthday);
            request.setAttribute("accountInput", account);
            if(invalidInput) {
                request.getRequestDispatcher("register.jsp").include(request,response);
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}
