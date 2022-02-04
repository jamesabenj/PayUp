package dev.benjamin.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.benjamin.models.User;
import dev.benjamin.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    ObjectMapper om = new ObjectMapper();
    UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder uriString = new StringBuilder(req.getRequestURI());
        uriString.replace(0, req.getContextPath().length() + 1, "");



        int userId = 0;


        /*if (uriString.indexOf("/") != uriString.length() - 1) {
            userId = Integer.parseInt(uriString.replace(0, uriString.indexOf("/") + 1, "" ).toString()); // if we had a request that was books/1, we want to access that 1. This line of code would save that Integer value into our bookId.
        }*/


        String path = uriString.toString();


        if (userId == 0) {
            HttpSession session = req.getSession(false);
            User u = (User) session.getAttribute("currentUser");

            if (session == null) {
                resp.sendRedirect("index.html");
            } else{
                resp.getWriter().write(om.writeValueAsString(u));
            }

        } else {
            User u = userService.getUserById(userId);
            System.out.println(u);
            resp.getWriter().write(om.writeValueAsString(u));
        }

    }
}
