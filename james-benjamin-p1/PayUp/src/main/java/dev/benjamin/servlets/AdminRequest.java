package dev.benjamin.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.benjamin.models.Request;
import dev.benjamin.models.Status;
import dev.benjamin.models.User;
import dev.benjamin.service.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AdminRequest extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    RequestService rs = new RequestService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect("index.html");
        } else{
            User user = (User) session.getAttribute("currentUser");
            List<Request> requests = rs.getRequestsByStatus(Status.PENDING);
            resp.getWriter().write(objectMapper.writeValueAsString(requests));
        }*/
        StringBuilder uriString = new StringBuilder(req.getRequestURI());
        uriString.replace(0, req.getContextPath().length() + 1, "");


        int requestId = 0;


        if (uriString.indexOf("/") != uriString.length() - 1) {
            requestId = Integer.parseInt(uriString.replace(0, uriString.indexOf("/") + 1, "" ).toString()); // if we had a request that was books/1, we want to access that 1. This line of code would save that Integer value into our bookId.
        }


        String path = uriString.toString();


        if (requestId == 0) {
            List<Request> requests = rs.getRequestsByStatus(Status.PENDING);
            resp.getWriter().write(objectMapper.writeValueAsString(requests));

        } else {
            Request r = rs.getById(requestId);
            resp.getWriter().write(objectMapper.writeValueAsString(r));
        }

    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.setStatus(401);
            resp.sendRedirect("index.html");
        } else{
            User user = (User) session.getAttribute("currentUser");
            Request request = objectMapper.readValue(req.getReader(), Request.class);
            System.out.println(request);
            request = rs.process(request, user);
            if(request != null) {
                resp.setStatus(200);
            } else {
                resp.setStatus(400);
            }
        }

    }
}
