package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
//class for users
public class MySQLUsersDao implements Users {
    private Connection connection;
// connects to the database
    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }
// places the user in the database
    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }
// deletes the user from the database
    public void delete(User user){
        try {
            String deleteQuery = "DELETE FROM users WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(deleteQuery);
            stmt.setLong(1, user.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting user.", e);
        }
    }
// updates the user in the database
    public void edit(User user){
        try{
            PreparedStatement stmt;
            String updateQuery;
            if (user.getPassword() == null){
                updateQuery = "update users set " +
                        "username = ?, " +
                        "email = ? " +
                        "where id = ?";
                stmt = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getEmail());
                stmt.setLong(3, user.getId());
                System.out.println(stmt.toString());
            }else {
                updateQuery = "update users set " +
                        "username = ?, " +
                        "email = ?, " +
                        "password = ? " +
                        "where id = ?";
                user.setPassword(user.getPassword());
                stmt = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPassword());
                stmt.setLong(4, user.getId());
            }
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error updating user.", e);
        }
    }
//extracts the user from the database
    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

}
