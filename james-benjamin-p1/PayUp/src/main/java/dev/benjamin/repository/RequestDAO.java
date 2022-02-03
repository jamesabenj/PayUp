package dev.benjamin.repository;

import dev.benjamin.models.Request;
import dev.benjamin.models.Status;
import dev.benjamin.models.User;
import dev.benjamin.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


public class RequestDAO {
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
    UserDAO ud = new UserDAO();

    public Request create(Request request, User user) {
        String sql = "insert into requests(id, cost, description, event_type, grade_format, provider, event_date, author_id, status) values(default, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, request.getCost());
            ps.setString(2, request.getDescription());
            ps.setString(3, request.getEventType());
            ps.setString(4, request.getGradeFormat());
            ps.setString(5, request.getProvider());
            ps.setString(6, request.getEventDate());
            ps.setInt(7, user.getId());
            request.setStatus(Status.PENDING);
            ps.setString(8, request.getStatus().toString());

            if(request != null) {
                ps.executeUpdate();
                return request;
            }

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Should retrieve a Request from the DB with the corresponding id or an empty optional if there is no match.
     */

    public List<Request> getAll(){
        List<Request> requests = new ArrayList<>();

        try(Connection conn = cu.getConnection()) {
            String sql = "select * from requests";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Request req = new Request();
                req.setId(rs.getInt("id"));
                req.setCost(rs.getDouble("cost"));
                req.setDescription(rs.getString("description"));
                req.setEventType(rs.getString("event_type"));
                req.setGradeFormat(rs.getString("grade_format"));
                req.setProvider(rs.getString("provider"));
                req.setEventDate(String.valueOf(rs.getDate("event_date")));
                req.setReimbursement(rs.getDouble("reimbursement"));
                req.setAuthor(ud.getById(rs.getInt("author_id")));
                req.setResolver(ud.getById(rs.getInt("resolver_id")));
                req.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));

                requests.add(req);
            }

            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Request> getAllByUser(User user) {
        List<Request> requests = new ArrayList<>();

        try(Connection conn = cu.getConnection()) {
            String sql = "select * from requests inner join users on (requests.author_id = ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Request req = new Request();
                req.setId(rs.getInt("id"));
                req.setCost(rs.getDouble("cost"));
                req.setDescription(rs.getString("description"));
                req.setEventType(rs.getString("event_type"));
                req.setGradeFormat(rs.getString("grade_format"));
                req.setProvider(rs.getString("provider"));
                req.setEventDate(String.valueOf(rs.getDate("event_date")));
                req.setReimbursement(rs.getDouble("reimbursement"));
                req.setAuthor(ud.getById(rs.getInt("author_id")));
                req.setResolver(ud.getById(rs.getInt("resolver_id")));
                req.setStatus(Status.valueOf(rs.getString("status").toUpperCase()));

                requests.add(req);
            }

            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
