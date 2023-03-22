package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
// interface for users
public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    void delete(User user);
    void edit(User user);
}
