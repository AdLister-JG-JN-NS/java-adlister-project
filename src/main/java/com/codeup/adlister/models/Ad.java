package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String company;
    private String job_type;
    private String location;
    private long salary;
// constructors  for ads
    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Ad(long id, long userId, String title, String description, String company, String job_type, String location, long salary) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.company = company;
        this.job_type = job_type;
        this.location = location;
        this.salary = salary;
    }

    public Ad(long userId, String title, String description, String company, String job_type, String location, long salary) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.company = company;
        this.job_type = job_type;
        this.location = location;
        this.salary = salary;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }


// getters and setters for ad
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
