package dev.benjamin.service;

import dev.benjamin.models.Request;
import dev.benjamin.models.Status;
import dev.benjamin.models.User;
import dev.benjamin.repository.RequestDAO;

import java.util.Collections;
import java.util.List;

public class RequestService {
    RequestDAO requestDAO = new RequestDAO();

    public Request newRequest(Request req, User user /*Double cost, String description, String eventType, String gradeFormat, String eventLocation, String eventDate, User user*/) {
        /*Request request = new Request();
        request.setCost(cost);
        request.setDescription(description);
        request.setEventType(eventType);
        request.setGradeFormat(gradeFormat);
        request.setProvider(eventLocation);
        request.setEventDate(eventDate);
        request.setStatus(Status.PENDING);*/
        requestDAO.create(req, user);
        return req;
    }

    public List<Request> getAllRequests() {
        return requestDAO.getAll();
    }

    public List<Request> getAllByUser(User user) {
        return requestDAO.getAllByUser(user);
    }



    /**
     * <ul>
     *     <li>Should ensure that the user is logged in as a Finance Manager</li>
     *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
     *     <li>Should ensure that the Request request exists</li>
     *     <li>Must throw exception if the Request request is not found</li>
     *     <li>Should persist the updated Request status with resolver information</li>
     *     <li>Must throw exception if persistence is unsuccessful</li>
     * </ul>
     *
     * Note: unprocessedRequest will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
     * The Resolver should be null. Additional fields may be null.
     * After processing, the Request will have its status changed to either APPROVED or DENIED.
     */
    public Request process(Request unprocessedRequest, Status finalStatus, User resolver) {
        return null;
    }

    /**
     * Should retrieve all Requests with the correct status.
     */
    public List<Request> getRequestsByStatus(Status status) {
        return Collections.emptyList();
    }
}
