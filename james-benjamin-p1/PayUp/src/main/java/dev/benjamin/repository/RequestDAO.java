package dev.benjamin.repository;

import dev.benjamin.models.Request;
import dev.benjamin.models.Status;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RequestDAO {
    /**
     * Should retrieve a Request from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Request> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Requests from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Request> getByStatus(Status status) {
        return Collections.emptyList();
    }

    /**
     * <ul>
     *     <li>Should Update an existing Request record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Request object with updated information.</li>
     * </ul>
     */
    public Request update(Request unprocessedRequest) {
        return null;
    }
}
