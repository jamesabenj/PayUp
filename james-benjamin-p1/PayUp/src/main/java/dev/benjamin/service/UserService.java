package dev.benjamin.service;

import dev.benjamin.repository.UserDAO;
import dev.benjamin.models.User;
import java.util.Optional;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public boolean login(String username, String password){

        User u = UserDAO.getByUsername(username);

        if (u != null){
            if (username.equals(u.getUsername())&& password.equals(u.getPassword()));
            return true;
        }
        System.out.println("Credentials do not match");
        return false;
    }



    /**
     *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }
}
