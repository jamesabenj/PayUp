package dev.benjamin.service;

import dev.benjamin.exceptions.NoSuchUserException;
import dev.benjamin.exceptions.WrongPasswordException;
import dev.benjamin.models.User;
import dev.benjamin.repository.UserDAO;


public class AuthService {
    UserDAO ud = new UserDAO();
    /**
     * <ul>
     *     <li>Needs to check for existing users with username/email provided.</li>
     *     <li>Must throw exception if user does not exist.</li>
     *     <li>Must compare password provided and stored password for that user.</li>
     *     <li>Should throw exception if the passwords do not match.</li>
     *     <li>Must return user object if the user logs in successfully.</li>
     * </ul>
     */
    public User login(String username, String password) {
        User u = ud.getByUsername(username);

        if(u != null) {
            if(u.getPassword().equals(password)) {
                return u;
            } else {
                throw new WrongPasswordException("Credentials do not match.");
            }
        } else {
            throw new NoSuchUserException("The user you're trying to modify does not exist.");
        }
    }

    /**
     * <ul>
     *     <li>Should ensure that the username/email provided is unique.</li>
     *     <li>Must throw exception if the username/email is not unique.</li>
     *     <li>Should persist the user object upon successful registration.</li>
     *     <li>Must throw exception if registration is unsuccessful.</li>
     *     <li>Must return user object if the user registers successfully.</li>
     *     <li>Must throw exception if provided user has a non-zero ID</li>
     * </ul>
     *
     * Note: userToBeRegistered will have an id=0, additional fields may be null.
     * After registration, the id will be a positive integer.
     */
    public User register(User userToBeRegistered) {
        return null;
    }

    /**
     * This is an example method signature for retrieving the currently logged-in user.
     * It leverages the Optional type which is a useful interface to handle the
     * possibility of a user being unavailable.
     */

}
