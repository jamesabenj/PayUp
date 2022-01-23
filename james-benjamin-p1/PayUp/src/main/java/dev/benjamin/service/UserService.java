package dev.benjamin.service;

import dev.benjamin.repository.UserDAO;
import dev.benjamin.models.User;

public class UserService {
    /*private UserDAO userDao = new UserDAO();

   *//* void handleLogin() throws NullPointerException {
        new Exception("We couldn't find a user with those credentials.");
    }*//*
    public boolean successfulLogin(String username, String password) {
        User u = userDao.getByUsername(username);

        if (u != null) {
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        //handleLogin();
        System.out.println("We couldn't find a user with those credentials.");
        return false;
    }*/
}
