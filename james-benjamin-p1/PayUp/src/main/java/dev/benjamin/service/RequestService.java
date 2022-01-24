package dev.benjamin.service;

import dev.benjamin.models.Request;
import dev.benjamin.models.Status;
import dev.benjamin.models.User;

import java.util.Collections;
import java.util.List;

public class RequestService {

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
