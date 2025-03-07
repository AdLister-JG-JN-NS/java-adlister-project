package com.codeup.adlister.models;

import com.codeup.adlister.util.Password;
// user class
public class User {
    private long id;
    private String username;
    private String email;
    private String password;

    public User() {}
// constructors for user
    public User(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        setPassword(password);
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
// getters and setters for user
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Password.hash(password);
    }
}
