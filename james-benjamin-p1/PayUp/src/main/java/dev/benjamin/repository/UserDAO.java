package dev.benjamin.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.benjamin.exceptions.NoSuchUserException;
import dev.benjamin.models.User;
import dev.benjamin.util.ConnectionUtil;


public class UserDAO {

    static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();


    /*public User create(User user) {
        String sql = "insert into users values (default, ?, ?, ?, ?, ?)";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setDouble(5, user.getBalance());

            ResultSet rs = ps.executeQuery();

            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }*/

    public static User getByUsername(String username) {
        String sql = "select * from users where username = ?";

        try (Connection conn = cu.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getDouble("balance"),
                        rs.getString("role")
                );
                return u;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User getById(Integer id) {
        String sql = "select * from users where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getDouble("balance"),
                        rs.getString("role")
                );

                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getDouble("balance"),
                        rs.getString("role")
                );
                users.add(u);
            }
            return users;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User updatePassword(User user, String newPassword) {
        String sql = "update users set password = ? where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, user.getId());

            if (user != null) {
                ps.executeQuery();
                return user;
            } else {
                throw new NoSuchUserException("The user you're trying to modify does not exist.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBalance(User user, double disbursement) {
        String sql = "update users balance = ? where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);

            if (user != null) {
                user.setBalance(disbursement);
            } else {
                throw new NoSuchUserException("The user you're trying to modify does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
