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

public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();
    ObjectMapper om = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        User u = (User) session.getAttribute("currentUser");

        if (session == null) {
            resp.sendRedirect("index.html");
            System.out.println("inside if");
        } else{
            session.invalidate();
            System.out.println("inside else");
            resp.sendRedirect("index.html");
            resp.getWriter().write(om.writeValueAsString(u));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = userService.login(username, password);

        if (u != null) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", u);
            resp.sendRedirect("dashboard.html");
        } else {
            resp.setStatus(401);
        }

    }
}
