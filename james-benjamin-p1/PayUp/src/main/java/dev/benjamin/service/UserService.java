package dev.benjamin.service;

import dev.benjamin.repository.UserDAO;
import dev.benjamin.models.User;


public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User login(String username, String password){
        User u = userDAO.getByUsername(username);

        if (u != null && u.getPassword().equals(password)) {
            return u;
        } else {
            return null;
        }
    }

    public User getUserById(int id) {
        return userDAO.getById(id);
    }



    /**
     *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */

}
