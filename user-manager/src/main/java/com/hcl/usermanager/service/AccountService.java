package com.hcl.usermanager.service;

import com.hcl.usermanager.domain.Account;
import com.hcl.usermanager.domain.DAO;
import com.hcl.usermanager.repository.AccountDAO;

import java.util.List;

public class AccountService {
    private static DAO<Account> accounts = new AccountDAO();

    private AccountService() {};

    public static boolean usernameExists(String username) {
        return (accounts.getByProperty("username", username) != null);
    }

    public static boolean validLogin(String username, String password) {
       List<Account> found = accounts.getByProperty("username", username);
       if(found != null) {
           if(found.get(0).getPassword().equals(password))
               return true;
       }

       return false;
    }

    public static Long getAccountId(String username) {
        return accounts.getByProperty("username", username).get(0).getId();
    }

    public static Account getById(long id) {
        return accounts.get(id);
    }

    public static Account add(Account account) {
        return accounts.add(account);
    }



}
