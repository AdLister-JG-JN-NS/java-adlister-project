package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
// interface for users
public interface Users {
    //find user by username and return the user object
    User findByUsername(String username);
    //insert user into database
    Long insert(User user);
    //delete user from database
    void delete(User user);
    //edit user in database
    void edit(User user);
}
