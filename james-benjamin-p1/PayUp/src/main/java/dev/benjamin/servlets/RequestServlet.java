package dev.benjamin.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.benjamin.models.Request;
import dev.benjamin.models.User;
import dev.benjamin.service.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class RequestServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    RequestService rs = new RequestService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect("index.html");
        } else{
            User user = (User) session.getAttribute("currentUser");
            List<Request> requests = rs.getAllByUser(user);
            System.out.println(requests);
            resp.getWriter().write(objectMapper.writeValueAsString(requests));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("currentUser");
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        /*Request request = rs.newRequest(
                Double.parseDouble(req.getParameter("cost")),
                req.getParameter("description"),
                req.getParameter("eventType"),
                req.getParameter("gradeFormat"),
                req.getParameter("provider"),
                req.getParameter("eventDate"),
                user
        );*/

        /*Request request = new Request();

                request.setCost(Double.parseDouble(req.getParameter("cost")));
                request.setDescription(req.getParameter("description"));
                request.setEventType(req.getParameter("eventType"));
                request.setGradeFormat(req.getParameter("gradeFormat"));
                request.setProvider(req.getParameter("provider"));
                request.setEventDate(req.getParameter("eventDate"));

        System.out.println(request);*/
        Request request = objectMapper.readValue(req.getReader(), Request.class);
        request = rs.newRequest(request, user);

        if (request != null) {
            resp.getWriter().write(objectMapper.writeValueAsString(rs.getAllRequests()));
        } else {
            resp.setStatus(401);
        }
    }
}
